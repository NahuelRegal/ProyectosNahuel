package BLACKJACK;

import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] palos = {"Corazones", "Diamantes"};
        String[] cartas = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] valores = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        int seguirJugando = 1;

        while (seguirJugando == 1) {
            int[] mazo = new int[52];
            for (int i = 0; i < mazo.length; i++) {
                mazo[i] = i;
            }

      
            for (int i = 0; i < mazo.length; i++) {
                int cartaRandom = random.nextInt(mazo.length);
                int cartaTemporal = mazo[i];
                mazo[i] = mazo[cartaRandom];
                mazo[cartaRandom] = cartaTemporal;
            }

        
            int casacarta1 = mazo[0];
            int casacarta2 = mazo[1];
            int casasuma = valores[casacarta1 % 13] + valores[casacarta2 % 13];
            System.out.println("La casa tiene: " + cartas[casacarta1 % 13] + " de " + palos[casacarta1 / 26] + " y " + cartas[casacarta2 % 13] + " de " + palos[casacarta2 / 26]);

       
            int jugadorcarta1 = mazo[2];
            int jugadorcarta2 = mazo[3];
            int jugadorsuma = valores[jugadorcarta1 % 13] + valores[jugadorcarta2 % 13];
            System.out.println("El jugador tiene: " + cartas[jugadorcarta1 % 13] + " de " + palos[jugadorcarta1 / 26] + " y " + cartas[jugadorcarta2 % 13] + " de " + palos[jugadorcarta2 / 26]);

          
            int proximaCarta = 4;

            
            while (jugadorsuma < 21) {
                System.out.println("Tu suma actual es: " + jugadorsuma);
                System.out.print("¿Querés pedir otra carta?  ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("si")) {
                    break;
                }
                jugadorsuma += valores[mazo[proximaCarta] % 13];
                System.out.println("Recibiste: " + cartas[mazo[proximaCarta] % 13] + " de " + palos[mazo[proximaCarta] / 26]);
                proximaCarta++;
            }

           
            if (casasuma < 17) {
                while (casasuma < 17) {
                    casasuma += valores[mazo[proximaCarta] % 13];
                    System.out.println("La casa recibe: " + cartas[mazo[proximaCarta] % 13] + " de " + palos[mazo[proximaCarta] / 26]);
                    proximaCarta++;
                }
            }
            
            System.out.println("La suma de la casa es: " + casasuma);
            System.out.println("La suma del jugador es: " + jugadorsuma);

            if (jugadorsuma > 21) {
                System.out.println("Te pasaste de 21 , ¡La casa gana!");
            } else if (casasuma > 21 || jugadorsuma > casasuma) {
                System.out.println("¡GANASTE!");
            } else if (jugadorsuma == casasuma) {
                System.out.println("¡EMPATE");
            } else {
                System.out.println("LA CASA GANA ");
            }

            // Preguntar si el jugador quiere seguir jugando
            System.out.print("¿Querés jugar de nuevo?");
            seguirJugando = scanner.nextLine().equalsIgnoreCase("si") ? 1 : 0;
        }

        scanner.close();
    }
}
