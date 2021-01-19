/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mycompany.proyecto_parcial2_2020.App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class Tablero {
   private ArrayList<Carta> cartas;
   
   public Tablero(){
       cartas = new ArrayList<>();
   }
   
   public ArrayList<Carta> getCartas(){
       return cartas;
   }
   
   public void lecturaArchivoCarta(){
       //Completar Metodo
       BufferedReader br = null;
       try{
           //Se lee el archivo y se toman los datos de numero y nombre de la carta
           br = new BufferedReader(new FileReader(App.pathArchivo));
           
           String line = br.readLine();
           while(line != null){
               //System.out.println(line);
               String[] datos = line.strip().split(",");
               //Se crea un for para iterar la lista de numeros y asi poder obtener
               //las imagenes
                String rutaImg = App.pathimagenes+datos[0]+".png";
                //La clase carta toma estos valores y los agrega a una lista de 
                //tipo carta
                Carta c = new Carta(datos[0], datos[1], rutaImg);
                //System.out.println("Carta" +c);
                cartas.add(c);
                line = br.readLine();

            }
       } catch (IOException e) {
            System.out.println("Error de IOEXCEPTION");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
       
       }
       
   }

