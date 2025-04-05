package com.campusdigital;

/**
 * Clase que representa una cuenta corriente corriente
 * 
 * @author Àngel Padilla
 */
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
	/**
	 * Método que devuelve todos los datos de la cuenta
	 */
	@Override
	public String devolverInfoString() {
		return "Cuenta Corriente Empresa: " + "Titular: " + getTitular().getNombre() + " " + getTitular().getApellidos()
				+ ", " + "IBAN: " + getIban() + ", " + "Saldo: " + getSaldo()+ "Entidades permitidas: "
						+ getListaEntidades();
	}
}
