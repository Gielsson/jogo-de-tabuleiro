package com.mycompany.jogodetabuleiro;

import java.util.Random;

public class Dados {

    private int dado1;
    private int dado2;
   private final Random random;

    public Dados() {
        this.random = new Random();
    }

    public void rolar() {
        dado1 = random.nextInt(6) + 1;
        dado2 = random.nextInt(6) + 1;
    }

    public int getDado1() { 
        return dado1; 
    }
    public int getDado2() { 
        return dado2;
    }
    public int getSoma() {
        return dado1 + dado2;
    }
    public boolean saoIguais() { 
        return dado1 == dado2;
    }
    
}