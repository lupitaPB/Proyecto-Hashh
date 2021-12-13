/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Clases.HASHH;
import Clases.TablaHash;
import javax.swing.JOptionPane;

/**
 *
 * @author lupit
 */
public class pruebaHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, resp, prom = 0, t = 0;
        String datos = "";
        String altura = "", nom;
        String[] elementos = null;
        String opc;

        //String[] elementos=datos.split(" ");
        HASHH[] h=null;

        do {
            Object[] menuPrincipal = {"Alumno", "Cuenta Bancaria", "Producto ", "Empleado", "Salir"};
            opc = leerOpcion(" REGISTROS " + "\nEligue la opcion a desear", menuPrincipal);
            switch (opc) {
                case "Alumno":
                    resp = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("MENU PRINCIPAL"
                            + "\nInsertar (1)\nBuscar (2)\nEliminar (3)\nMstrar Tabla(4) \nSalir (5)"));
                    switch (resp) {
                        case 1:
                            t = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Cuantos Alumnos Registraras "));
                            h=new HASHH[t];
                            for (int i = 0; i < t; i++) {
                                h[i] = new HASHH();
                                h[i].setEstado(0);
                            }
                            for (int i = 0; i < t; i++) {
                                nom = JOptionPane.showInputDialog("Ingresa el NOMBRE del estudiante: ");
                                n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número de CONTROL: "));
                                prom = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el PROMEDIO: "));
                                HASHH.insertaHash(h, t, n,prom,nom);
                                
                            }

                            break;
                        case 2:
                            int i;
                            n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número a ser buscado en la tabla:"));
                            i = HASHH.buscaHash(h, t, n);
                            if (i == -1) {
                                javax.swing.JOptionPane.showMessageDialog(null, "Número no encontrado");
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(null, "Número encontrado");
                            }
                            break;
                        case 3:
                             n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número de CONTROL: "));
                            HASHH.eliminaHash(h, t, n);
                            break;
                        case 4:
                            
                          break;  
                    }

                    break;

            }

        } while (opc != "Salir");
        /*
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
         */
    }

    public static void generarValores(String[] elementos) {
        for (int i = 0; i < 8; i++) {
            elementos[i] = "" + (int) (Math.random() * 100 + 1);
        }
        System.out.println(" Elementos ");
        for (String e : elementos) {
            System.out.println(" " + e);
        }
        System.out.println();
    }

    //METODO QUE LEE LAS CADENAS STRING
    public static String leerOpcion(String mensaje, Object[] opciones) {
        String opc = "";
        try {
            opc = (String) JOptionPane.showInputDialog(null, mensaje, "LISTA DE OPCIONES",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        }//fin del try
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Regresando al menu");
        }
        return opc;
    }//fin leerOpcion

}
