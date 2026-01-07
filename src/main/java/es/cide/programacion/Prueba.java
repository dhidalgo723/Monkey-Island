package es.cide.programacion;

import java.util.Random;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();

        String[] respuestas = { // respuestas para defenderse
                "Primero deberías dejar de usarla como un plumero",
                "Qué apropiado, tú peleas como una vaca",
                "Sí que las hay, sólo que nunca las has aprendido",
                "Ya te están fastidiando otra vez las almorranas, ¿Eh?",
                "Aargh.. ¿Y después que? ¿Te la comerás?.",
                "Me rendiría si eso me evitara tener que mirarte.",
                "Ugh... por eso te rascas con tanta saña. Que te vea un veterinario.",
                "¿Será que tu eres Michael Jackson o como?"
        };

        String[] insulto = { // los insultos del pirata
                "Mi lengua es más hábil que cualquier espada",
                "¡Ordeñaré hasta la última gota de sangre de tu cuerpo!",
                "Ya no hay técnicas que te puedan salvar",
                "¡Eres como un dolor en la parte baja de la espalda!",
                "Aargh... Moleré tus nudillos hasta hacerlos pasta.",
                "Ríndete ahora o te aplastaré como a un tomate.",
                "He visto pulgas con brazos más grandes que los tuyos.",
        };

        // creacion de variables
        boolean vivoh = true; // si el heroe sigue vivo
        boolean correcta = true; // si es correcta la pregunta
        int vidap = ra.nextInt(3) + 1; // vida del pirata
        int vidachuck = vidap * 2;
        int vidah = 10; // vida del heroe
        int rondas = 0; // rondas (lo toma como el numero de piratas que genera la isla)
        String nomp = "Grumete"; // el pirata elegido
        String chuck = "LeChuck";
        String nomh = ""; // el nombre del heroe

        Heroi h = null; // variable del heroe
        Pirata pelegido = null; // variable del pirata elegido
        Illa i = new Illa(); // clase isla

        rondas = i.getNumpirata(); // obtenemos el numero de piratas

        int elec_personaje;
        System.out.println("Elige tu personaje:");
        System.out.println("1: Guybrush Threepwood");
        System.out.println("2: Elaine Marley");
        elec_personaje = sc.nextInt(); // la eleccion del personaje
        if (elec_personaje == 1) {
            nomh = "Guybrush Threepwood";
            h = new Guybrush(nomh, 10, true);
        } else if (elec_personaje == 2) {
            nomh = "Elaine Marley";
            h = new Elaine(nomh, 10, true);
        }

        System.out.println("Has llegado a la isla: " + i.getNomisla());
        // ayuda tio
        
        while (vivoh && rondas > 0) {
                Pirata lc = new LeChuck(chuck, vidachuck, true); // creamos la clase piratanormal
                // imprimir hola de chuck y adios de chuck
                while (vidachuck > 0 && vivoh) { // mientras el heroe siga vivo y la vida del pirata no sea 0
                    System.out.println("\n" + chuck + " te dice: ");
                    lc.insultar(); // ataque
                    System.out.println("\n" + nomh + " responde: ");
                    h.defensar(); // defensa del heroe
                    correcta = lc.replica(h.getElec());
                    if (correcta) {
                        System.out.println("\nUgh... has ganado por los pelos de mi loro");
                        vidachuck = lc.getVida(); // resta uno de vida al pirata si la acierta el heroe
                        System.out.println("La vida del pirata es de: " + vidachuck);
                        System.out.println("¿Sigue vivo el pirata?: " + lc.vida());
                    } else if (!correcta) {
                        System.out.println("\n¿Pero tu le das de beber a los peces?");
                        vidah = h.getVida(); // resta uno de vida al heroe si falla el heroe
                        System.out.println("La vida del heroe es de: " + vidah);
                        System.out.println("¿Sigue vivo el heroe?: " + h.vida());
                    }
                    if (vidah <= 0) { // si la vida del heroe es 0 (muere) sale del bucle
                        System.out.println("\n Has muerto");
                        vivoh = false;
                    }
            }
            rondas--;
        }

    }
}
