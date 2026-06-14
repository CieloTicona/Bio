/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author HP
 */
public class PuntoDeVenta {
  	private String ubicacion;
	private Inventario inventario;
	private Venta[] ventas;
	private int cantVentas;

	public PuntoDeVenta(String ubicacion, Inventario inventario) {
		this.ubicacion = ubicacion;
		this.inventario = inventario;
		this.ventas = new Venta[100];
		this.cantVentas = 0;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void abrirPuntoDeVenta() {
		System.out.println(ubicacion + " ABIERTO ");
		System.out.println("Fecha: " + inventario.getFecha());
	}

	public void cerrarPuntoDeVenta() {
		System.out.println(ubicacion + " CERRADO");
		System.out.println("Ventas del día: " + cantVentas);
	}

	public void consultarInventario() {
		inventario.mostrar();
	}

	public void registrarVenta(Venta v) {
		if (cantVentas < 100) {
			ventas[cantVentas] = v;
			cantVentas++;
			System.out.println("Venta registrada exitosamente.");
		}
	}

	public void listarVentasPorDia(String dia) {
		System.out.println("=== VENTAS DEL " + dia + " ===");
		for (int i = 0; i < cantVentas; i++) {
			ventas[i].mostrar();
		}
	}

	public void mostrarDetalles() {
		System.out.println("Ubicación: " + ubicacion);
		System.out.println("Ventas registradas: " + cantVentas);
		inventario.mostrar();
	}
  
}
