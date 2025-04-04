package com.campusdigital;
/**
 * Clase que representa una cuenta corriente personal
 * 
 * @author Àngel Padilla
 * 
 */
public class CuentaCorrientePersonal extends CuentaCorriente {
	/**
	 * Tipo de comisión para estas cuentas
	 */
	private double comisionMantenimiento;

	/**
	 * @param titular
	 * @param iban
	 * @param saldo
	 * @param listaEntidades
	 * @param comisionMantenimiento
	 */
	public CuentaCorrientePersonal(Persona titular, String iban, double saldo, String listaEntidades,
			double comisionMantenimiento) {
		super(titular, iban, saldo, listaEntidades);
		this.comisionMantenimiento = comisionMantenimiento;
	}

//	/**
//	 * Método que devuelve todos los datos de la cuenta
//	 */
//	@Override
//	public String devolverInfoString() {
//		return "Cuenta Corriente Personal: " + "Titular: " + getTitular().getNombre() + " "
//				+ getTitular().getApellidos() + ", " + "IBAN: " + getIban() + ", " + "Saldo: " + getSaldo() + "€, "
//				+ "Entidades permitidas: " + getListaEntidades() + ", " + "Comisión de mantenimiento: "
//				+ comisionMantenimiento + "€";
//	}
}
