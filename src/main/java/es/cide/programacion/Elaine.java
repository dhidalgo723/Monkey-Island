package es.cide.programacion;

import java.util.Random;

public class Elaine extends Heroi implements Fight, Speak {

    Random ra = new Random();
    protected String nom;
    protected int elec_array;
    protected String[] respuestas = { // respuestas para defenderse
        "Primero deberías dejar de usarla como un plumero",
        "Qué apropiado, tú peleas como una vaca",
        "Sí que las hay, sólo que nunca las has aprendido",
        "Ya te están fastidiando otra vez las almorranas, ¿Eh?",
        "Aargh.. ¿Y después que? ¿Te la comerás?.",
        "Me rendiría si eso me evitara tener que mirarte.",
        "Ugh... por eso te rascas con tanta saña. Que te vea un veterinario.",
        "Cierto… ¡Lo navega tu mujer!"
    };

    public Elaine(String nom, int vida, boolean vivo) {
        super(nom, vida, vivo);
        this.nom = nom;
        this.vida = vida;
        this.vivo = vivo;
    }

    public void defensar() { // metodo defender
        boolean correcta = true;
        int eleccion;
        for (int i = 0; i < respuestas.length; i++) { // imprime las respuestas
            System.out.println(i + ". " + respuestas[i]);
        }
        eleccion = sc.nextInt(); // la eleccion
        elec_array = eleccion;
        System.out.print("Has escogido: " + eleccion);
    }

    @Override
    public String getElec() {
        return respuestas[elec_array];
    }

    @Override
    public int getVida() { // vida para el heroe
        this.vida = vida - 1;
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
        System.out.println("Un placer conoceros, me llamo Elaine Marley");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Adios, que los vientos os sean favorables");
    }
}
