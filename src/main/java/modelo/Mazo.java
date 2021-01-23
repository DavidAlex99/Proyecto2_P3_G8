/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author cholo
 */
public class Mazo {
    private ArrayList<Carta> cartas;
    //atrivtos anadidos
    private int fila = 0;
    private int columna = 0;
    private Carta carta;
    
    public Mazo(Carta carta, int columna, int fila){
        this.carta = carta;
        this.columna = columna;
        this.fila = fila;
    }
    
    public Mazo(ArrayList<Carta> cartas){
        this.cartas = new ArrayList<>();
    }
    public ArrayList<Carta> getCartas(){
        return cartas;
    }
    
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Carta getCarta() {
        return carta;
    }
    //public void barajar(){
    //}
    
    public void mostrarCarta(){
        
    }
}
