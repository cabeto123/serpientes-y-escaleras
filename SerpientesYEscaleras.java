/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serpientesyescaleras;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlosmoncada
 */
public class SerpientesYEscaleras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Integer> aux = new ArrayList<Integer>();
        ArrayList<Jugadores> listajugadores = new ArrayList<Jugadores>();
        String[][] matriz = new String[8][8];
        matriz = llenarmatriz(matriz);
        listajugadores = crearjugadores();
        for (int i = 0; i < listajugadores.size(); i++) {
            System.out.println("Jugador " + (i + 1) + " ingrese la tecla D para tirar los dados");
            char letra = entrada.next().charAt(0);
            letra = verificarletra(letra);
            int sumadados = dados();
            if (listajugadores.get(i).columna + sumadados <= 7) {
                int columnas = listajugadores.get(i).columna + sumadados;
                int fila = listajugadores.get(i).fila;

                aux = escaleraoserpiente(fila, columnas);
                for (int j = 0; j < aux.size(); j++) {
                    if (j == 0) {
                        fila = aux.get(j);
                    } else {
                        columnas = aux.get(j);
                    }

                }
                if (matriz[fila][columnas] != "") {
                    matriz[fila][columnas] += listajugadores.get(i).pieza;

                } else {
                    matriz[fila][columnas] = listajugadores.get(i).pieza;

                }
                listajugadores.get(i).setFila(fila);
                listajugadores.get(i).setColumna(columnas);
                aux.clear();
            } else {
                int columnas = listajugadores.get(i).getColumna();
                int fila = listajugadores.get(i).getFila();
                int cont = 0;

                while (cont < sumadados) {
                    columnas++;
                    cont++;
                    if (columnas == 8) {
                        fila--;
                        columnas = 0;

                    }

                }
                aux = escaleraoserpiente(fila, columnas);
                for (int j = 0; j < aux.size(); j++) {
                    if (j == 0) {
                        fila = aux.get(j);
                    } else {
                        columnas = aux.get(j);
                    }

                }

                if (matriz[fila][columnas] != "") {
                    matriz[fila][columnas] += listajugadores.get(i).pieza;
                } else {
                    matriz[fila][columnas] = listajugadores.get(i).pieza;

                }
                listajugadores.get(i).setColumna(columnas);
                listajugadores.get(i).setFila(fila);
                aux.clear();

            }
            imprimir(matriz);
        }

    }

    public static String[][] llenarmatriz(String[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = " ";
            }
        }
        return matriz;
    }

    public static char verificarletra(char letra) {
        Scanner entrada = new Scanner(System.in);
        while (letra != 'd' && letra != 'D') {
            System.out.println("Caracter invalido digite otra vez");
            letra = entrada.next().charAt(0);
        }
        return letra;
    }

    public static int dados() {
        int suma = 0;
        int dado1 = (int) ((Math.random() * (6 - 1)) + 1);
        int dado2 = (int) ((Math.random() * (6 - 1)) + 1);
        System.out.println("Dado 1= " + dado1 + "  dado 2= " + dado2);
        suma = dado1 + dado2;

        return suma;
    }

    public static void imprimir(String[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }

    }

    public static ArrayList<Jugadores> crearjugadores() {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Jugadores> listajugadores = new ArrayList();
        String nombre = "";
        String pieza = "";
        System.out.println("Digite de cuantos jugadores quiere jugar ?");
        int cantjgd= entrada.nextInt();
        for (int i = 0; i < cantjgd; i++) {

            System.out.println("Digite su nombre: ");
            nombre = entrada.nextLine();
            if (i==0) {
            nombre = entrada.nextLine();    
            }
            System.out.println("Digite algun simbolo para su pieza");
            pieza = entrada.nextLine();

            boolean banderapieza = false;
            boolean banderanombre = false;
            do {

                for (int j = 0; j < listajugadores.size(); j++) {
                    if (pieza.equalsIgnoreCase(listajugadores.get(j).pieza)==true) {
                        banderapieza = true;
                    }
                    if (nombre.equalsIgnoreCase(listajugadores.get(j).nombre)==true) {
                        banderanombre = true;

                    }
                }
                if (banderapieza == true) {
                    System.out.println("Pieza repetida digite otra vez ");
                    pieza = entrada.nextLine();
                    banderapieza = false;
                } else {
                    banderapieza = false;
                }
                if (banderanombre == true) {
                    System.out.println("Nombre repetido digite otra vez ");
                    nombre = entrada.nextLine();
                    banderanombre = false;
                } else {
                    banderanombre = false;
                }

            } while ((banderapieza == true) ||(banderanombre == true));
            //fin del while en el que se verifica el nombre y jugador
                listajugadores.add(new Jugadores(7, 0, nombre, pieza));//se llena hasta por algun cambio que pueda suceder jaja
            }//fin del for en el que se llena el jugador
            return listajugadores;
        }

    

    public static ArrayList<Integer> escaleraoserpiente(int fila, int columna) {

        ArrayList<Integer> filacolumnas = new ArrayList<Integer>();

        //Escaleras
        if (fila == 0 && columna == 2) {
            System.out.println("Cayo en una escalera");
            filacolumnas.add(2);
            filacolumnas.add(2);
        } else if (fila == 1 && columna == 6) {
            System.out.println("Cayo en una escalera");
            filacolumnas.add(5);
            filacolumnas.add(5);
        } else if (fila == 3 && columna == 0) {
            System.out.println("Cayo en una escalera");

            filacolumnas.add(7);
            filacolumnas.add(0);

        }
        //Serpientes 
        if (columna == 4 && fila == 1) {
            System.out.println("Cayo en una serpiente");
            filacolumnas.add(6);
            filacolumnas.add(3);

        } else if (columna == 3 && fila == 6) {
            System.out.println("Cayo en una serpiente");
            filacolumnas.add(1);
            filacolumnas.add(4);

        }
        if (columna == 2 && fila == 7) {
            System.out.println("Cayo en una serpiente");
            filacolumnas.add(7);
            filacolumnas.add(4);

        } else if (columna == 4 && fila == 7) {
            System.out.println("Cayo en una serpiente");
            filacolumnas.add(2);
            filacolumnas.add(7);

        }

        return filacolumnas;
    }

}
