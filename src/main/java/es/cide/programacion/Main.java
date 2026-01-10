package es.cide.programacion;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();

        // creacion de variables
        boolean vivoh = true; // si el heroe sigue vivo
        boolean correcta = true; // si es correcta la pregunta
        int vidap = 0; // vida del pirata
        int vidachuck = 0; // inicializamos la vida de lechuck
        int vidah = 10; // vida del heroe
        int rondas = 0; // rondas (lo toma como el numero de piratas que genera la isla)
        String nomp = ""; // el pirata elegido
        String chuck = "LeChuck";
        String nomh = ""; // el nombre del heroe

        Heroi h = null; // variable del heroe
        Pirata pelegido; // variable del pirata elegido
        Illa i = new Illa(); // clase isla
        rondas = i.getNumpirata(); // inicializamos rondas
        pelegido = i.vullUnPirata(ra.nextInt(rondas)); // la inicializamos para evitar errores

        int elec_personaje;
        System.out.println("Elige tu personaje:");
        System.out.println("1: Guybrush Threepwood");
        System.out.println("2: Elaine Marley");
        elec_personaje = sc.nextInt(); // la eleccion del personaje
        if (elec_personaje == 1) {
            nomh = "Guybrush Threepwood";
            h = new Guybrush(nomh, vidah, vivoh);
        } else if (elec_personaje == 2) {
            nomh = "Elaine Marley";
            h = new Elaine(nomh, vidah, vivoh);
        }
        h.sayHello(); // saludo del heroe

        System.out.println("Has llegado a la isla: " + i.getNomisla() + "\n"); // imprime el nombre de la isla

        while (vivoh && rondas > 0) { // mientras el heroe siga vivo y haya piratas
            if (rondas == 1) {
                pelegido = i.vullUnPirata(i.getNumpirata() - 1);
                nomp = pelegido.getNomPirata(); // lo convertimos en string para la clase pirata
                vidachuck = vidap * 2; // la vida de lechuck es el doble que la del pirata normal
            } else {
                pelegido = i.vullUnPirata(ra.nextInt(i.getNumpirata() - 1)); // obtenemos un pirata
                nomp = pelegido.getNomPirata(); // lo convertimos en string para la clase pirata
            }
            Pirata p = new Pirata(nomp, vidap = ra.nextInt(3) + 1, true); // creamos la clase piratanormal
            p.sayHello(); // saludo del pirata
            while (vidap > 0 && vivoh) { // mientras el heroe siga vivo y la vida del pirata no sea 0
                System.out.println("\n" + nomp + " te dice: ");
                p.insultar(); // ataque
                System.out.println("\n" + nomh + " responde: ");
                h.defensar(); // defensa del heroe
                correcta = p.replica(h.getElec());
                if (correcta) {
                    System.out.println("\nUgh... has ganado por los pelos de mi loro");
                    vidap = p.getVida(); // resta uno de vida al pirata si la acierta el heroe
                    System.out.println("La vida del pirata es de: " + vidap);
                    System.out.println("¿Sigue vivo el pirata?: " + p.vida()); // dice si el pirata sigue vivo
                } else if (!correcta) {
                    System.out.println("\n¿Pero tu le das de beber a los peces?");
                    vidah = h.getVida(); // resta uno de vida al heroe si falla el heroe
                    System.out.println("La vida del heroe es de: " + vidah);
                    System.out.println("¿Sigue vivo el heroe?: " + h.vida()); // dice si el heroe sigue vivo
                }
                if (vidah <= 0) { // si la vida del heroe es 0 (muere) sale del bucle
                    System.out.println("Has muerto");
                    vivoh = false;
                }
            }
            rondas--; // resta uno al numero de piratas que aparecen en la isla (rondas)
        }

        if (vivoh) { // si sigue vivo el heroe gana
            System.out.println("Has ganado el juego ¡Enhorabuena!");
        } else if (!vivoh) { // si muere
            System.out.println("Has dado mas pena que respuestas");
        }
        sc.close();
    }
}
