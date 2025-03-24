package com.campusdigital;

public class CuentaAhorro extends CuentaBancaria {
	double tipoInteresAnual;

	/**
	 * @param titular
	 * @param iban
	 * @param saldo
	 * @param tipoInteresAnual
	 */
	public CuentaAhorro(Persona titular, String iban, double saldo, double tipoInteresAnual) {
		super(titular, iban, saldo);
		this.tipoInteresAnual = tipoInteresAnual;
	}

	public CuentaAhorro(Persona titular, String iban, double saldo) {
		super(titular, iban, saldo);
		// TODO Auto-generated constructor stub
	}

}
