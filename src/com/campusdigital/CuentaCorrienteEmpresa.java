package com.campusdigital;

/**
 * Clase que representa una cuenta corriente empresa
 * @author Àngel Padilla
 * 
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {
	/**
	 * Tipo de interés que se aplica por un descubierto
	 */
	double tipoInteresDescubierto;
	/**
	 * Comisión que se aplica por un descubierto
	 */
	double comisionPordescubierto;
	/**
	 * Límite máximo de saldo negativo permitido
	 */
	double maximoDescubiertoPermitido;

	/**
	 * @param titular
	 * @param iban
	 * @param saldo
	 * @param listaEntidades
	 * @param tipoInteresDescubierto     Tasa de interés para descubierto
	 * @param comisionPordescubierto     Comisión fija por transacción en
	 *                                   descubierto
	 * @param maximoDescubiertoPermitido Límite de saldo negativo
	 */
	public CuentaCorrienteEmpresa(Persona titular, String iban, double saldo, String listaEntidades,
			double tipoInteresDescubierto, double comisionPordescubierto, double maximoDescubiertoPermitido) { // Parámetro
																												// añadido
		super(titular, iban, saldo, listaEntidades);
		this.tipoInteresDescubierto = tipoInteresDescubierto;
		this.comisionPordescubierto = comisionPordescubierto;
		this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
	}

	/**
	 * Método que devuelve todos los datos de la cuenta
	 */
	@Override
	public String devolverInfoString() {
		return "Cuenta Corriente Empresa: " + "Titular: " + getTitular().getNombre() + " " + getTitular().getApellidos()
				+ ", " + "IBAN: " + getIban() + ", " + "Saldo: " + String.format("%.2f", getSaldo()) + "€, "
				+ "Entidades permitidas: " + getListaEntidades() + ", " + "Límite Descubierto: "
				+ String.format("%.2f", this.maximoDescubiertoPermitido) + "€, " + "Interés por descubierto: "
				+ String.format("%.2f%%", this.tipoInteresDescubierto * 100) + ", " + "Comisión por descubierto: "
				+ String.format("%.2f", this.comisionPordescubierto) + "€";
	}

	/**
	 * Intenta retirar una cantidad de la cuenta. Aplica comisión por descubierto si
	 * la operación resulta en saldo negativo y está dentro del límite permitido.
	 *
	 * @param cantidad La cantidad positiva a retirar.
	 * @return true si la retirada fue exitosa, false en caso contrario.
	 */
	@Override
	public boolean retirarSaldo(double cantidad) {
		// --- Validación inicial ---
		if (cantidad <= 0) {
			System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
			return false;
		}

		double saldoActual = getSaldo();
		double nuevoSaldoPotencial = saldoActual - cantidad;

		if (nuevoSaldoPotencial >= 0) {
			setSaldo(nuevoSaldoPotencial);
			return true;
		} else {
			if (nuevoSaldoPotencial >= -this.maximoDescubiertoPermitido) {
				double saldoFinalConComision = nuevoSaldoPotencial - this.comisionPordescubierto;

				if (saldoFinalConComision >= -this.maximoDescubiertoPermitido) {
					setSaldo(saldoFinalConComision);
					return true;
				} else {
					// La comisión haría exceder el límite, no se permite la operación
					return false;
				}
			} else {
				// El descubierto potencial excede el límite máximo permitido
				return false;
			}
		}
	}

	/**
	 * @return the tipoInteresDescubierto
	 */
	public double getTipoInteresDescubierto() {
		return tipoInteresDescubierto;
	}

	/**
	 * @param tipoInteresDescubierto the tipoInteresDescubierto to set
	 */
	public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
		this.tipoInteresDescubierto = tipoInteresDescubierto;
	}

	/**
	 * @return the comisionPordescubierto
	 */
	public double getComisionPordescubierto() {
		return comisionPordescubierto;
	}

	/**
	 * @param comisionPordescubierto the comisionPordescubierto to set
	 */
	public void setComisionPordescubierto(double comisionPordescubierto) {
		this.comisionPordescubierto = comisionPordescubierto;
	}

	/**
	 * @return the maximoDescubiertoPermitido
	 */
	public double getMaximoDescubiertoPermitido() {
		return maximoDescubiertoPermitido;
	}

	/**
	 * @param maximoDescubiertoPermitido the maximoDescubiertoPermitido to set
	 */
	public void setMaximoDescubiertoPermitido(double maximoDescubiertoPermitido) {
		this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
	}
	

}
