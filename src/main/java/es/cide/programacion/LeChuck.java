package es.cide.programacion;

import java.util.Random;

public class LeChuck extends Pirata implements Fight, Speak {

    Random ra = new Random();

    protected String nom = "LeChuck";
    protected int vida;
    protected boolean vivo = true;
    protected Pirata p;

    protected boolean correcta0 = true; // si es correcta la respuesta
    protected int ataqueog, ataqueog1, ataqueog2; // los ataques randomizados
    protected String[] ataquerandomizado = new String[4];
    protected int pirata = ra.nextInt(3);
    protected int posog; // la posicion original del insulto del pirata
    protected String ataque = "";

    private String[] insulto = { // los insultos del pirata
        "Mi lengua es más hábil que cualquier espada",
        "¡Ordeñaré hasta la última gota de sangre de tu cuerpo!",
        "Ya no hay técnicas que te puedan salvar",
        "¡Eres como un dolor en la parte baja de la espalda!",
        "Aargh... Moleré tus nudillos hasta hacerlos pasta.",
        "Ríndete ahora o te aplastaré como a un tomate.",
        "He visto pulgas con brazos más grandes que los tuyos."
    };

    private String insultochuck = "¡Tu barco navega mejor sin ti!"; // el insultos de chuck

    protected String chuckanswer = "Cierto… ¡Lo navega tu mujer!";

    public LeChuck(String nom, int vida, boolean vivo) {
        super(nom, vida, vivo);
        this.nom = nom;
        this.vida = vida;
        this.vivo = vivo;
        ataqueog = ra.nextInt(3); // randomiza el primer ataque del pirata
        ataqueog1 = ra.nextInt(3);
        while (ataqueog == ataqueog1) {
            ataqueog1 = ra.nextInt(3);
        }
        ataqueog2 = ra.nextInt(3);
        while (ataqueog1 == ataqueog2 || ataqueog == ataqueog2) {
            ataqueog2 = ra.nextInt(3);
        }
        ataquerandomizado[0] = insulto[ataqueog]; // se sobreescribe en el array los insutlos randomizados
        ataquerandomizado[1] = insulto[ataqueog1];
        ataquerandomizado[2] = insulto[ataqueog2];
        ataquerandomizado[3] = insultochuck;
    }

    @Override
    public void insultar() {// metodo insultar
        int indiceinsultos = ra.nextInt(4); // elige aleatoriamente uno de los tres insultos guardados
        if (ataquerandomizado[indiceinsultos] == insulto[ataqueog]) { // esto es para que en replica podamos saber la
            // posicion original del insulto
            posog = ataqueog;
        } else if (ataquerandomizado[indiceinsultos] == insulto[ataqueog1]) {
            posog = ataqueog1;
        } else if (ataquerandomizado[indiceinsultos] == insulto[ataqueog2]) {
            posog = ataqueog2;
        } else if (ataquerandomizado[indiceinsultos] == insultochuck) {
            posog = 3;
        }
        ataque = ataquerandomizado[indiceinsultos]; // guardamos el insulto que dira
        System.out.println(ataque);
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean replica(String def) { // metodo para comprobar si la respuesta fue correcta
        if (def.equals(chuckanswer)) {
            return true;
        }
        return def.equals(respuestas[posog]); // la defensa del heroe es igual a la posicion original de la respuesta
    }

    public String getInsultog() {
        return ataquerandomizado[posog];
    }

    public String getAtaque() {
        return ataque;
    }

    public boolean vida() {
        return vivo;
    }

    @Override
    public void sayHello() {
        System.out.println("¡JAJA, Vas a ver mi ira!");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("¡NOOOOOOOOOOOOOOOOOOOOOOOO");
    }

}
