/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.io.Serializable;
/**
 *
 * @author HP
 */
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
private String nombre, tipo, lugarOrigen;
	private Float precio;
	private int cantidad;
	
	public Producto(String n, String t, String lo, float p, int c) {
		nombre=n;
		tipo=t;
		lugarOrigen=lo;
		precio=p;
		cantidad=c;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void mostrar() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Tipo: "+tipo);
		System.out.println("Cantidad: "+cantidad);
		System.out.println("Precio unitario: "+precio);
		System.out.println("Lugar de origen: "+lugarOrigen);
	}
	
	public void actualizarCantidad(int cant) {
	    cantidad += cant;
	    System.out.println("Cantidad actualizada :D");
	}

	public void disminuirCantidad(int cant) {
	    if(cantidad >= cant) {
	        cantidad -= cant;
	    } else {
	        System.out.println("No hay suficiente stock");
	    }
	}
}
