package es.cide.programacion;

import java.util.Random;

public class Guybrush extends Heroi implements Fight, Speak {

    Random ra = new Random();
    protected String nom;
    protected String[] respuestarandom = new String[4];
    protected int elec_array;
    protected int respuestaog, respuestaog1, respuestaog2, respuestaog3;
    protected String[] respuestas = { // respuestas para defenderse
        "Primero deberías dejar de usarla como un plumero",
        "Qué apropiado, tú peleas como una vaca",
        "Sí que las hay, sólo que nunca las has aprendido",
        "Ya te están fastidiando otra vez las almorranas, ¿Eh?",
        "Aargh.. ¿Y después que? ¿Te la comerás?.",
        "Me rendiría si eso me evitara tener que mirarte.",
        "Ugh... por eso te rascas con tanta saña. Que te vea un veterinario."
    };

    public Guybrush(String nom, int vida, boolean vivo) {
        super(nom, vida, vivo); // constructor heredado
        this.nom = nom;
        this.vida = vida;
        this.vivo = vivo;
        respuestaog = ra.nextInt(7); // randomiza el lugar del array de las respuestas
        respuestaog1 = ra.nextInt(7);
        while (respuestaog == respuestaog1) { // mientras sean iguales sigue haciendo randoms
            respuestaog1 = ra.nextInt(7);
        }
        respuestaog2 = ra.nextInt(7); // randomiza el lugar del array de las respuestas
        while (respuestaog1 == respuestaog2 || respuestaog == respuestaog2) { // mientras sean iguales sigue haciendo
            // randoms
            respuestaog2 = ra.nextInt(7);
        }
        respuestaog3 = ra.nextInt(7); // randomiza el lugar del array de las respuestas
        while (respuestaog == respuestaog3 || respuestaog1 == respuestaog3 || respuestaog2 == respuestaog3) {
            respuestaog3 = ra.nextInt(7);
        }
        respuestarandom[0] = respuestas[respuestaog]; // se sobreescribe en el array los insutlos randomizados
        respuestarandom[1] = respuestas[respuestaog1];
        respuestarandom[2] = respuestas[respuestaog2];
        respuestarandom[3] = respuestas[respuestaog3];
    }

    public void defensar() { // metodo defender
        boolean correcta = true;
        int eleccion;
        for (int i = 0; i < respuestarandom.length; i++) {
            System.out.println(i + ". " + respuestarandom[i]);
        }
        eleccion = sc.nextInt(); // la eleccion
        elec_array = eleccion;
        System.out.print("Has escogido: " + eleccion);
    }

    @Override
    public String getElec() {
        return respuestarandom[elec_array];
    }

    @Override
    public int getVida() { // vida para el heroe
        this.vida = vida - 2;
        if (vida != 0) { // si es diferente a 0 sigue vivo
            return vida;
        } else if (vida == 0) { // si es igual a 0 esta muerto
            System.out.println("Estas muerto");
            vivo = false;
        }
        return vida;
    }

    @Override
    public boolean vida() {
        return vivo;
    }

    @Override
    public void insultar() {
    }

    @Override
    public void sayHello() {
        System.out.println("¡Argh, Saludos Gaznápido!");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("¡Gracias por el botín tarado!");
    }
}
