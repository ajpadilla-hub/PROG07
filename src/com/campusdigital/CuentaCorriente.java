package com.campusdigital;

public abstract class CuentaCorriente extends CuentaBancaria {
	String listaEntidades;

	/**
	 * @param titular
	 * @param iban
	 * @param saldo
	 * @param listaEntidades
	 */
	public CuentaCorriente(Persona titular, String iban, double saldo, String listaEntidades) {
		super(titular, iban, saldo);
		this.listaEntidades = listaEntidades;
	}

	public CuentaCorriente(Persona titular, String iban, double saldo) {
		super(titular, iban, saldo);
		// TODO Auto-generated constructor stub
	}

}
