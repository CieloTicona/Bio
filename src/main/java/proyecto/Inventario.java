/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.*;
import java.io.*;
import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Inventario implements Serializable {

    private int cantProd;
    private String fecha;
    private Producto[] p = new Producto[100];

    public Inventario(int c, String f) {
        Scanner w = new Scanner(System.in);
        cantProd = c;
        fecha = f;
        for (int i = 0; i < c; i++) {
            System.out.println("Ingrese nombre del producto");
            System.out.println("Ingrese tipo(Organico/Procesado)");
            System.out.println("Ingrese lugar de origen(cota-cota/patacamaya/viacha)");
            System.out.println("Ingrese precio");
            System.out.println("Ingrese cantidad del producto que desea agregar:");
            p[i] = new Producto(w.next(), w.next(), w.next(), w.nextFloat(), w.nextInt());
        }
        for (int j = c; j < 100; j++) {
            p[j] = new Producto("", "", "", -1, -1);
        }
    }

    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Producto[] getP() {
        return p;
    }

    public void setP(Producto[] p) {
        this.p = p;
    }

    public void mostrar() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Cantidad de productos: " + cantProd);
        for (int i = 0; i < cantProd; i++) {
            System.out.println("Producto " + (i + 1));
            p[i].mostrar();
            System.out.println();
        }
    }

    public void agregarProducto(Producto p) {
        if (cantProd < 100) {
            this.p[cantProd] = p;
            cantProd++;
        } else {
            System.out.println("El inventario está lleno");
        }
    }

    public void quitarProducto(String n) {
        for (int i = 0; i < cantProd; i++) {
            if (p[i].getNombre().equals(n)) {
                for (int j = i; j < cantProd - 1; j++) {
                    p[j] = p[j + 1];
                }
                cantProd--;
                p[cantProd] = new Producto("", "", "", -1, -1);
                break;
            }
        }
    }

    public boolean buscarProducto(String nombre) {
        for (int i = 0; i < cantProd; i++) {
            if (p[i].getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public float calcularValorInventario() {
        float total = 0;
        for (int i = 0; i < cantProd; i++) {
            if (p[i] != null) {
                total += p[i].getCantidad() * p[i].getPrecio();
            }
        }
        return total;
    }

    public void listarPorDia(String dia) {
        System.out.println("PRODUCTOS DEL " + dia);
        System.out.println("Fecha: " + fecha);
        boolean hayProductos = false;
        for (int i = 0; i < cantProd; i++) {
            if (p[i].getLugarOrigen() != null && !p[i].getNombre().equals("")) {
                p[i].mostrar();
                hayProductos = true;
            }
        }
        if (!hayProductos) {
            System.out.println("No hay productos para " + dia);
        }
    }

    public void persistirDatos(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this); // Guarda TODO el objeto inventario con su arreglo adentro
            System.out.println("Datos guardados en disco duro.");
        } catch (IOException e) {
            System.out.println("Error al persistir: " + e.getMessage());
        }
    }

    // === NUEVO MÉTODO PARA RECUPERARPERSISTENCIA) ===
    public static Inventario recuperarDatos(String archivo) {
        File f = new File(archivo);
        if (!f.exists()) {
            return null; // Si no existe el archivo (primera corrida), devuelve null
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Inventario) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error al recuperar: " + e.getMessage());
            return null;
        }
    }

}
