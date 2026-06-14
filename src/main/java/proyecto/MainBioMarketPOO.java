/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;


import vista.RegistrarProductos;

public class MainBioMarketPOO {

    public static void main(String[] args) {
        
        String archivoDatos = "datos_biomarket.dat";
        
        System.out.println("=== INICIANDO SISTEMA BIOMARKET UMSA ===");
        
        Inventario I1 = Inventario.recuperarDatos(archivoDatos);
       
        if (I1 == null) {
            System.out.println("No se encontró archivo previo. Creando inventario inicial para el Mercado...");
            I1 = new Inventario(0, "Lunes"); // Al pasarle 0, no te pedirá nada por consola
        } else {
            System.out.println("¡Persistencia activada! Productos cargados: " + I1.getCantProd());
        }

        PuntoDeVenta PV = new PuntoDeVenta("BioMarket - Monoblock UMSA", I1);
        PV.abrirPuntoDeVenta();
        
        System.out.println("\nINVENTARIO ACTUAL EN MEMORIA:");
        I1.mostrar(); 

        System.out.println("\nAbriendo entorno gráfico...");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        
                RegistrarProductos ventana = new RegistrarProductos(new javax.swing.JFrame(), true);
                ventana.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                ventana.setVisible(true); // La hace visible
            }
        });
    }
}