/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author HP
 */
public class Persona {
private String nombre, paterno,materno;
	private int CI;
	
	public Persona(String nom,String pat,String mat,int C) {
		nombre=nom;
		paterno=pat;
		materno=mat;
		CI=C;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public int getCI() {
		return CI;
	}

	public void setCI(int cI) {
		CI = cI;
	}
	public void mostrar() {
		System.out.println("El nombre es :"+nombre);
		System.out.println("El apellido paterno es :"+paterno);
		System.out.println("El apellido materno es :"+materno);
		System.out.println("El CI es :"+CI);
	}
}
