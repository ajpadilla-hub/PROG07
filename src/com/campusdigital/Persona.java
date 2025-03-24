package com.campusdigital;

public class Persona implements Imprimible {
	String nombre, apellidos, dni;

	@Override
	public String devolverInfoString() {
		return "nombre: " + nombre + " apellidos: " + apellidos + " DNI: " + dni;
	}

}
