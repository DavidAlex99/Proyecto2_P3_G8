/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;


/**
 *
 * @author PC
 */
public class Tablero {
   private ArrayList<CartaJuego> cartas;
   
   public Tablero(ArrayList<CartaJuego> cartas){
       this.cartas = cartas;
   }
   
   public ArrayList<CartaJuego> getCartas(){
       return cartas;
   }
   
   public void llenarTablero(){
       //Completar Metodo
   }
}
