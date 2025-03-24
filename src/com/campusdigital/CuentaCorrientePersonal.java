package com.campusdigital;

public class CuentaCorrientePersonal extends CuentaCorriente{

	double comisionMantenimiento;
	public CuentaCorrientePersonal(Persona titular, String iban, double saldo) {
		super(titular, iban, saldo);
		// TODO Auto-generated constructor stub
	}
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

}
