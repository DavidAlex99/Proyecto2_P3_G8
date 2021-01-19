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
    
    public Mazo(ArrayList<Carta> cartas){
        this.cartas = new ArrayList<>();
    }
    public ArrayList<Carta> getCartas(){
        return cartas;
    }
    
    //public void barajar(){
    //}
    
    public void mostrarCarta(){
    }
}
