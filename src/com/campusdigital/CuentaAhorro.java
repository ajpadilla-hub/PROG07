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

	/**
	 * Intenta retirar una cantidad de la cuenta de ahorro.
	 *
	 * @param cantidad La cantidad positiva a retirar.
	 * @return true si la retirada fue exitosa, false si no hay saldo suficiente.
	 */
	@Override
	public boolean retirarSaldo(double cantidad) {

		if (cantidad <= 0) {
			System.err.println("Error: La cantidad a retirar debe ser positiva.");
			return false;
		}

		double saldoActual = getSaldo();
		if (saldoActual >= cantidad) {

			double nuevoSaldo = saldoActual - cantidad;
			setSaldo(nuevoSaldo);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método que devuelve todos los datos de la cuenta
	 */
	@Override
	public String devolverInfoString() {
		// Formateamos la salida para claridad y consistencia
		return "Cuenta Ahorro: " + "Titular: " + getTitular().getNombre() + " " + getTitular().getApellidos() + ", "
				+ "IBAN: " + getIban() + ", " + "Saldo: " + String.format("%.2f", getSaldo()) + "€, " // Formato de
																										// saldo
				+ "Interés Anual: " + String.format("%.2f", tipoInteresAnual * 100) + "%"; // Mostrar como porcentaje
	}
	
	
}
