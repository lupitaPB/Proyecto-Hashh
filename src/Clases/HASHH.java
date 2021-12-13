package Clases;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//@author lupit y joab

public class HASHH {
    int dato;
    int estado; //0 = Vacío, 1 = Eliminado, 2 = Ocupado
    int promedio;
    String nombre;
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public static int funcion(int n, int m) {
        return ((n) % m);
    }
    public static void insertaHash(HASHH[] h, int m, int n, int prom, String nom) {
        boolean i = false;
        int j = funcion(n, m);
        do {
            if (h[j].estado == 0 || h[j].estado == 1) {
                h[j].dato = n;
                h[j].promedio = prom;
                h[j].nombre = nom;
                h[j].estado = 2;
                i = true;
            } else {
                j++;
            }
        } while (j < m && !i);
        
        if (i) {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Elemento insertado con éxito!");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Tabla llena!");
        }
    }
    public void funcionHash(String[] cadenaArreglo, int t, String[] h) {
        int i;
        for (i = 0; i < cadenaArreglo.length; i++) {
            String elemento = cadenaArreglo[i];
            int indiceArreglo = Integer.parseInt(elemento) % (t - 1);
            System.out.println("El indice es " + indiceArreglo + " Para el elemento " + elemento);
            //tratamiento de colision
            while (Integer.parseInt(h[indiceArreglo]) != -1) {
                indiceArreglo++;
                System.out.println("Ocurrio una colison en el indice " + (indiceArreglo - 1) + " Cambiar al indice "
                        + indiceArreglo);
                indiceArreglo %= t;
            }
            h[indiceArreglo] = elemento;
        }
    }
    public static int buscaTabla(HASHH[] h, int m, int n, JTable t) {
        DefaultTableModel modelo1 = (DefaultTableModel) t.getModel();
        int j = funcion(n, m);
        while (j < m) {
            if (h[j].estado == 0) {
                return -1;
            } else if (h[j].dato == n) {
                if (h[j].estado == 1) {
                    return -1;
                } else {
                    modelo1.addRow(new Object[]{h[j].dato, h[j].promedio, h[j].nombre});
                    return j;
                }
            } else {
                j++;
            }
        }return -1;
    }
    public static int buscaHash(HASHH[] h, int m, int n) {
        int j = funcion(n, m);
        while (j < m) {
            if (h[j].estado == 0) {
                return -1;
            } else if (h[j].dato == n) {
                if (h[j].estado == 1) {
                    return -1;
                } else {
                    return j;
                }
            } else {
                j++;
            }
        }
        return -1;

    }
    public static int eliminaHash(HASHH[] h, int m, int n) {
        int i = buscaHash(h, m, n);
        if (i == -1) {
            return -1;
        } else {
            h[i].estado = 1;
            return 1;
        }
    }
}
