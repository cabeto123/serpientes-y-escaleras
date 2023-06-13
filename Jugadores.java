/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serpientesyescaleras;

import java.util.ArrayList;

/**
 *
 * @author carlosmoncada
 */
public class Jugadores {
int fila;
int columna;
String nombre;
String pieza;


    public Jugadores(int fila, int columna, String nombre, String pieza) {
        this.fila = fila;
        this.columna = columna;
        this.nombre = nombre;
        this.pieza = pieza;
        
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        this.pieza = pieza;
    }
    

    

}
