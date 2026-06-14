/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;


import vista.RegistrarProducto;

public class MainBioMarketPOO {

    public static void main(String[] args) {
        // 1. Definimos la ruta del archivo de persistencia (el mismo nombre que en la vista)
        String archivoDatos = "datos_biomarket.dat";
        
        System.out.println("=== INICIANDO SISTEMA BIOMARKET UMSA ===");
        
        // 2. Intentamos recuperar el inventario del archivo binario
        Inventario I1 = Inventario.recuperarDatos(archivoDatos);
        
        // 3. Si el archivo no existe (primera corrida), creamos el inventario vacío sin usar Scanner
        if (I1 == null) {
            System.out.println("No se encontró archivo previo. Creando inventario inicial para el Mercado...");
            I1 = new Inventario(0, "Lunes"); // Al pasarle 0, no te pedirá nada por consola
        } else {
            System.out.println("¡Persistencia activada! Productos cargados: " + I1.getCantProd());
        }

        // 4. CREAR PUNTO DE VENTA Y MOSTRAR DATOS EN CONSOLA (Para el reporte del docente)
        PuntoDeVenta PV = new PuntoDeVenta("BioMarket - Monoblock UMSA", I1);
        PV.abrirPuntoDeVenta();
        
        System.out.println("\nINVENTARIO ACTUAL EN MEMORIA:");
        I1.mostrar(); 

        // 5. ¡EL TOQUE MÁGICO! Abrimos tu interfaz gráfica en pantalla
        System.out.println("\nAbriendo entorno gráfico...");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Instanciamos tu ventana JDialog pasándole un Frame vacío
                RegistrarProductos ventana = new RegistrarProductos(new javax.swing.JFrame(), true);
                ventana.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                ventana.setVisible(true); // La hace visible
            }
        });
    }
}