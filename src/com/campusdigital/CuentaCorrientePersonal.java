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
	 * Constructor
	 * 
	 * @param titular
	 * @param iban
	 * @param saldo
	 * @param listaEntidades
	 * @param comisionMantenimiento Comisión anual (ej: 30.0)
	 */
	public CuentaCorrientePersonal(Persona titular, String iban, double saldo, String listaEntidades,
			double comisionMantenimiento) {
		super(titular, iban, saldo, listaEntidades);
		this.comisionMantenimiento = comisionMantenimiento;
	}

	/**
	 * Método que devuelve todos los datos de la cuenta
	 */
	@Override
	public String devolverInfoString() {
		// Tu implementación está bien, añado formato para consistencia
		return "Cuenta Corriente Personal: " + "Titular: " + getTitular().getNombre() + " "
				+ getTitular().getApellidos() + ", " + "IBAN: " + getIban() + ", " + "Saldo: "
				+ String.format("%.2f", getSaldo()) + "€, " // Formato de saldo
				+ "Entidades permitidas: " + getListaEntidades() + ", " + "Comisión de mantenimiento: "
				+ String.format("%.2f", comisionMantenimiento) + "€"; // Formato de comisión
	}

	/**
	 * Intenta retirar una cantidad de la cuenta que solo es posible si el saldo 
	 * actual es mayor o igual a la cantidad.
	 *
	 * @param cantidad La cantidad positiva a retirar.
	 * @return true si la retirada fue exitosa, false si no hay saldo suficiente.
	 */
	@Override
	public boolean retirarSaldo(double cantidad) {
		if (cantidad <= 0) {
			System.err.println("Error: La cantidad a retirar debe ser positiva.");
			return false; // Operación inválida
		}

		// Comprobar si hay saldo suficiente (NO se permite descubierto)
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
	 * @return the comisionMantenimiento
	 */
	public double getComisionMantenimiento() {
		return comisionMantenimiento;
	}

	/**
	 * @param comisionMantenimiento the comisionMantenimiento to set
	 */
	public void setComisionMantenimiento(double comisionMantenimiento) {
		this.comisionMantenimiento = comisionMantenimiento;
	}
	
}
