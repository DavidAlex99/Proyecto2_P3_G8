/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author cholo
 */
public class CartaJuego {
    private Carta carta;
    private boolean marcada;
    
    public CartaJuego(Carta carta, boolean marcada){
        this.carta = carta;
        this.marcada = marcada;
    }
    public Carta getCarta(){
        return carta;
    }
    public boolean getMarcada(){
        return marcada;
    }
    
    
}
