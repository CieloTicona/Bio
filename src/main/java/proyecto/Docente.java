/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author HP
 */
public class Docente extends Persona {
	private String cargo, areaResponsable;
	private Estudiante[] asistencia;
	private int cantAsistentes;

	public Docente(String nom, String pat, String mat, int C, String ca, String ar) {
		super(nom, pat, mat, C);
		cargo = ca;
		areaResponsable = ar;
		asistencia = new Estudiante[50];
        cantAsistentes = 0;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getAreaResponsable() {
		return areaResponsable;
	}

	public void setAreaResponsable(String areaResponsable) {
		this.areaResponsable = areaResponsable;
	}

	public void mostrar() {
		super.mostrar();
		System.out.println("Cargo: " + cargo);
		System.out.println("Área responsable: " + areaResponsable);
	}

	public void registrarProducto(Producto p) {
		System.out.println("Producto registrado: " + p.getNombre());
	}

	public void registrarAsistencia(Estudiante e) {
		if (cantAsistentes < 50) {
			asistencia[cantAsistentes] = e;
			cantAsistentes++;
			System.out.println("Asistencia registrada: " + e.getNombre());
		} else {
			System.out.println("Lista de asistencia llena.");
		}
	}

	public void generarReporte() {
		System.out.println("REPORTE DE ASISTENCIA");
		for (int i = 0; i < cantAsistentes; i++) {
			asistencia[i].mostrar();
		}
		System.out.println("Total asistentes: " + cantAsistentes);
	}

	public void revisarInventario() {
		System.out.println("Revisando inventario....");
	}

}
