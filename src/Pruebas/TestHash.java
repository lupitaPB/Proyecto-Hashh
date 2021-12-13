/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Clases.TablaHash;
import javax.swing.JOptionPane;

/**
 *
 * @author lupit
 */
public class TestHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       TablaHash hash=new TablaHash(8);
       String datos="99 91 53 20 89 12 97 36";
       String[] elementos=datos.split(" ");
       //String[]elementos=new String[8]
      
       //generarValores(elementos);
        System.out.println("Elementos= "+ hash);     
        hash.funcionHash(elementos);
        hash.mostrar();
        String clave;
        do{
            clave=JOptionPane.showInputDialog("Clave a buscar? ");
            String salida=hash.buscarClave(clave);
            System.out.println("salida");
        }while(clave.charAt(0)!='0');
    }
    
    public static void generarValores(String[] elementos){
        for (int i = 0; i < 8; i++) {
            elementos[i]=""+(int)(Math.random()*100+1);           
        }
        System.out.println(" Elementos ");
        for (String e: elementos) {
            System.out.println(" "+e);          
        }
        System.out.println();
    }
    
}
