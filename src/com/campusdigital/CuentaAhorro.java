package com.campusdigital;

/**
 * Clase que representa una cuenta ahorro
 * 
 * @author Àngel Padilla
 * 
 */
public class CuentaAhorro extends CuentaBancaria {
	/**
	 * Tipo de interés anual que se le aplica a este tipo de cuenta
	 */
	private double tipoInteresAnual;

	/**
	 * 
	 * @param titular
	 * @param iban
	 * @param saldo
	 * @param tipoInteresAnual
	 */
	public CuentaAhorro(Persona titular, String iban, double saldo, double tipoInteresAnual) {
		super(titular, iban, saldo);
		this.tipoInteresAnual = tipoInteresAnual;
	}

	/**
	 * @return the tipoInteresAnual
	 */
	public double getTipoInteresAnual() {
		return tipoInteresAnual;
	}

	/**
	 * @param tipoInteresAnual the tipoInteresAnual to set
	 */
	public void setTipoInteresAnual(double tipoInteresAnual) {
		this.tipoInteresAnual = tipoInteresAnual;
	}

	@Override
	public boolean retirarSaldo(double cantidad) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Método que devuelve todos los datos de la cuenta
	 */
	@Override
	public String devolverInfoString() {
		return "Cuenta Ahorro: " + "Titular: " + getTitular().getNombre() + " " + getTitular().getApellidos() + ", "
				+ "IBAN: " + getIban() + ", " + "Saldo: " + getSaldo() + "€, " + "Interés Anual: " + tipoInteresAnual
				+ "%";
	}
}
