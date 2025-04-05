package com.campusdigital;

/**
 * Clase que representa una cuenta corriente bancaria
 * 
 * @author Àngel Padilla
 */
public abstract class CuentaBancaria implements Imprimible {

	/**
	 * Nombre, apellidos y DNI del titular
	 */
	protected Persona titular;
	/**
	 * Número de cuenta del titulartitular
	 */
	protected String iban;
	/**
	 * Saldo del titulartitular
	 */
	protected double saldo;
	/**
	 * Método que devuelve todos los datos de la cuenta
	 */
	@Override
	public String devolverInfoString() {
		return "Cuenta Corriente Empresa: " + "Titular: " + getTitular().getNombre() + " " + getTitular().getApellidos()
				+ ", " + "IBAN: " + getIban() + ", " + "Saldo: " + getSaldo();
	}

	/**
	 * @param titular
	 * @param iban
	 * @param saldo
	 */
	public CuentaBancaria(Persona titular, String iban, double saldo) {
		this.setTitular(titular);
		this.iban = iban;
		this.saldo = saldo;
	}

	public abstract boolean retirarSaldo(double cantidad);
	/**
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * @return the titular
	 */
	public Persona getTitular() {
		return titular;
	}

	/**
	 * @param titular the titular to set
	 */
	public void setTitular(Persona titular) {
		this.titular = titular;
	}
}
