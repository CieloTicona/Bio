/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author HP
 */
public class Venta {
	private String fecha, metodoPago, diaDeVenta;
	private float total;
	private Estudiante e;
	private int cantProd;
	private Producto[] p = new Producto[50];

	public Venta(String f, String mp, String d) {
		fecha = f;
		metodoPago = mp;
		diaDeVenta = d;
		cantProd = 0;
	}
	public void mostrar() {
	    System.out.println("Fecha: " + fecha);
	    System.out.println("Día: " + diaDeVenta);
	    System.out.println("Total: " + total);
	    System.out.println("Método de pago: " + metodoPago);
	}



	public void calcularTotal() {
		total = 0;
		for (int i = 0; i < cantProd; i++) {
			total += p[i].getPrecio() * p[i].getCantidad();
		}
	}
	public void registrarVenta() {
	    calcularTotal();
	    System.out.println("VENTA REGISTRADA");
	    System.out.println("Fecha: " + fecha);
	    System.out.println("Día: " + diaDeVenta);
	    System.out.println("Cantidad de productos: " + cantProd);
	    for (int i = 0; i < cantProd; i++) {
	        p[i].mostrar();
	    }
	    System.out.println("Total: " + total);
	    System.out.println("Método de pago: " + metodoPago);
	}

	public float calcularCambio(float recibido) {
		return recibido - total;
	}

	//como Venta no tiene el inventario habría q poner en el main algo q verifique si el producto a agregar está en el inventario
	public void agregarProducto(Producto p) {
		if (cantProd < 50) {
			this.p[cantProd] = p;
			cantProd++;
		}
	}

	public void mostrarTicket() {
		System.out.println("--- TICKET DE VENTA ---");
		System.out.println("Fecha: " + fecha);
		System.out.println("Dia: " + diaDeVenta);
		System.out.println("Metodo de pago: " + metodoPago);
		if (e != null)
			System.out.println("Vendedor: " + e.getNombre());
		System.out.println();
		for (int i = 0; i < cantProd; i++) {
			System.out.println(p[i].getNombre() + " - Cantidad: " + p[i].getCantidad() + " - Precio: " + p[i].getPrecio());
		}
		System.out.println("------------------------");
		System.out.println("TOTAL: " + total);
	}
}
