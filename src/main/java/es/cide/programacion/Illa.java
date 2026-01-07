package es.cide.programacion;

import java.util.Random;

public class Illa {

    Random ra = new Random();

    private String[] nompirata = { // array de los piratas
        "Margit, el Augurio Caído dice:",
        "Ignacio Queso dice:",
        "Kaido, El que no puede morir dice:",
        "Cervantes, el Manco de Lepanto dice:",
        "El Pirata, Sin Nombre dice:"
    };

    protected String nomisla = "Monkey Island"; // nombre de la isla guardado en el random de el array de la isla randomizada
    protected int numpirata; // numero de piratas
    protected int vidap; // vida del pirata
    protected Pirata[] pirataelegido;

    public Illa() {
        numpirata = ra.nextInt(5) + 3; // genera un numero entre 3 y 7 piratas
        pirataelegido = new Pirata[numpirata]; // crea el array de piratas elegidos con un tamaño de lo numeros de
        // pirata escogidos
        for (int i = 0; i < numpirata; i++) { // guarda los piratas en el array pirataelegido, usa como posicion la "i"
            // para guardar en cada posicion del array, ademas creamos el objeto
            // "pirata" para que guarde un nombre de los piratas del array de los
            // piratas
            pirataelegido[i] = new Pirata(nompirata[ra.nextInt(nompirata.length)], vidap, true); // los guarda ERROR
        }
    }

    public String getNomisla() { // para tener la isla
        return nomisla;
    }

    public Pirata vullUnPirata(int index) { // devuelve un pirata de los que estan en el array del pirataelegido
        return pirataelegido[index];
    }

    public int getNumpirata() { // devuelve el numero de piratas
        return numpirata;
    }

}
