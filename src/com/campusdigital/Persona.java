package com.campusdigital;

/**
 * Clase que contiene los datos personales del titular de una cuenta
 * 
 * @author Àngel Padilla
 */
public class Persona implements Imprimible {
	String nombre, apellidos, dni;

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 */
	public Persona(String nombre, String apellidos, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Método que devuelve todos los datos del titular
	 */
	@Override
	public String devolverInfoString() {
		return "nombre: " + nombre + " apellidos: " + apellidos + " DNI: " + dni;
	}

}
