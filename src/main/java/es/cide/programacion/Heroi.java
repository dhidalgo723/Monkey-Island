package es.cide.programacion;

import java.util.Scanner;

abstract class Heroi extends Personatge implements Fight, Speak {

    Scanner sc = new Scanner(System.in);
    protected String nom;
    protected int vida;
    protected String[] respuestas;
    protected int elec_array;
    protected boolean vivo = true;

    protected Heroi(String nom, int vida, boolean vivo) {
        super(nom, vida);
        this.vivo = vivo;
    }

    public String getElec() {
        return respuestas[elec_array];
    }

    protected int getVida() { // vida para el heroe
        return vida;
    }

    public void sayHello() {
        System.out.println("¡Hola!");
    }

    @Override
    public boolean vida() {
        return vivo;
    }

    public abstract void defensar(); // metodo defender

}
