package es.cide.programacion;

import java.util.Random;

public class Pirata extends Personatge implements Fight, Speak {

    protected Random ra = new Random();
    protected String nomh;
    protected int vidah;
    protected String[] respuestas = { // respuestas para defenderse
        "Primero deberías dejar de usarla como un plumero",
        "Qué apropiado, tú peleas como una vaca",
        "Sí que las hay, sólo que nunca las has aprendido",
        "Ya te están fastidiando otra vez las almorranas, ¿Eh?",
        "Aargh.. ¿Y después que? ¿Te la comerás?.",
        "Me rendiría si eso me evitara tener que mirarte.",
        "Ugh... por eso te rascas con tanta saña. Que te vea un veterinario.",};

    protected String nom0; // nombre del pirata
    protected int vida; // vida del pirata
    protected boolean vivo = true; // si sigue vivo el pirata
    protected boolean correcta0 = true; // si es correcta la respuesta
    protected int ataqueog, ataqueog1, ataqueog2, ataquechuck; // los ataques randomizados
    protected String[] ataquerandomizado = new String[3];
    protected int pirata = ra.nextInt(3);
    protected int posog; // la posicion original del insulto del pirata

    private String[] insulto = { // los insultos del pirata
        "Mi lengua es más hábil que cualquier espada",
        "¡Ordeñaré hasta la última gota de sangre de tu cuerpo!",
        "Ya no hay técnicas que te puedan salvar",
        "¡Eres como un dolor en la parte baja de la espalda!",
        "Aargh... Moleré tus nudillos hasta hacerlos pasta.",
        "Ríndete ahora o te aplastaré como a un tomate.",
        "He visto pulgas con brazos más grandes que los tuyos."
    };

    public Pirata(String nom, int vida, boolean vivo) { // constructor de pirata
        super(nom, vida);
        this.vida = vida;
        this.vivo = vivo;
        ataqueog = ra.nextInt(7); // randomiza el primer ataque del pirata
        ataqueog1 = ra.nextInt(7);
        while (ataqueog == ataqueog1) {
            ataqueog1 = ra.nextInt(7);
        }
        ataqueog2 = ra.nextInt(7);
        while (ataqueog1 == ataqueog2 || ataqueog == ataqueog2) {
            ataqueog2 = ra.nextInt(7);
        }
        ataquerandomizado[0] = insulto[ataqueog]; // se sobreescribe en el array los insultos randomizados
        ataquerandomizado[1] = insulto[ataqueog1];
        ataquerandomizado[2] = insulto[ataqueog2];
    }

    public void insultar() {// metodo insultar
        int indiceinsultos = ra.nextInt(3); // elige aleatoriamente uno de los tres insultos guardados
        if (ataquerandomizado[indiceinsultos] == insulto[ataqueog]) { // esto es para que en replica podamos saber la
            // posicion original del insulto
            posog = ataqueog;
        } else if (ataquerandomizado[indiceinsultos] == insulto[ataqueog1]) {
            posog = ataqueog1;
        } else if (ataquerandomizado[indiceinsultos] == insulto[ataqueog2]) {
            posog = ataqueog2;
        }
        String ataque = ataquerandomizado[indiceinsultos]; // guardamos el insulto que dira
        System.out.println(ataque);
    }

    public boolean replica(String def) { // metodo para comprobar si la respuesta fue correcta
        return def.equals(respuestas[posog]); // la defensa del heroe es igual a la posicion original de la respuesta
    }

    public String getNomPirata() { // devuelve el nombre del pirata
        return this.nom;
    }

    public int getVida() {
        this.vida = vida - 1;
        if (vida != 0) { // si es diferente a 0 esta vivo
            return vida;
        } else if (vida == 0) { // si es igual a 0 pasa al siguiente pirata
            System.out.println("Pasamos al siguiente pirata");
            vivo = false;
        }
        return vida;
    }

    public boolean vida() {
        return vivo;
    }

    public void defensar() { // metodo defender
    }

    @Override
    public void sayHello() {
        System.out.println("¡Que miras mequetrefe!");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("¡Vete a tomar un viento, me has ganao!");
    }
}
