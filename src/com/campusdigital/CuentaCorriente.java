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

	/**
	 * @return the listaEntidades
	 */
	public String getListaEntidades() {
		return listaEntidades;
	}

	/**
	 * @param listaEntidades the listaEntidades to set
	 */
	public void setListaEntidades(String listaEntidades) {
		this.listaEntidades = listaEntidades;
	}

}
