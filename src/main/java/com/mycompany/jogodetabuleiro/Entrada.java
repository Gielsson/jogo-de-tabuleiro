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
            //scanner.nextLine().trim() le td linha q ele digitar em "mensagem" e retira os espaços 
            //trim tira os espaços entre as oalavras
            try { //tenta transformar em um numero inteiro
                int valor = Integer.parseInt(texto);
                if (valor >= min && valor <= max) {
                    //verifica se esta dentro do intervalo permitid entre min e max
                    return valor;
                }
            } catch (NumberFormatException e) { // ve o erro e faz cm que o program n feche
                // cai na mensagem abaixo
            }
            System.out.println("Valor invalido. Digite um numero de " + min + " a " + max + ".");
        }
    }

    //espera o usuario apertar Enter
    public static void esperarEnter(String mensagem) {
        System.out.print(mensagem);
        scanner.nextLine();
        //espera o enmter para poder avançar
    }
}
