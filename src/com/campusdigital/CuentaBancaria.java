package com.campusdigital;

public abstract class CuentaBancaria implements Imprimible {

	/**
	 * 
	 */
	private Persona titular;
	/**
	 * 
	 */
	private String iban;
	/**
	 * 
	 */
	private double saldo;

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
