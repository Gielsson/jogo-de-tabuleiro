package com.mycompany.jogodetabuleiro;

import java.util.Scanner;

// Leitura do teclado num lugar so 
public class Entrada {
    private static Scanner scanner = new Scanner(System.in);

    //pede um numero entre min e max, repetindo ate o usuario acertar
    public static int lerInt(String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(texto);
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                // cai na mensagem abaixo
            }
            System.out.println("Valor invalido. Digite um numero de " + min + " a " + max + ".");
        }
    }

    //espera o usuario apertar Enter
    public static void esperarEnter(String mensagem) {
        System.out.print(mensagem);
        scanner.nextLine();
    }
}
