package com.campusdigital;

/**
 * Clase que representa una cuenta corriente empresa
 * 
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
	 * @param titular
	 * @param iban
	 * @param saldo
	 * @param listaEntidades
	 * @param tipoInteresDescubierto
	 * @param comisionPordescubierto
	 */
	public CuentaCorrienteEmpresa(Persona titular, String iban, double saldo, String listaEntidades,
			double tipoInteresDescubierto, double comisionPordescubierto) {
		super(titular, iban, saldo, listaEntidades);
		this.tipoInteresDescubierto = tipoInteresDescubierto;
		this.comisionPordescubierto = comisionPordescubierto;
	}

//	/**
//	 * Método que devuelve todos los datos de la cuenta
//	 */
//	@Override
//	public String devolverInfoString() {
//		return "Cuenta Corriente Empresa: " + "Titular: " + getTitular().getNombre() + " " + getTitular().getApellidos()
//				+ ", " + "IBAN: " + getIban() + ", " + "Saldo: " + getSaldo() + "€, " + "Entidades permitidas: "
//				+ getListaEntidades() + ", " + "Interés por descubierto: " + tipoInteresDescubierto + "%, "
//				+ "Comisión por descubierto: " + comisionPordescubierto + "€";
//	}
}
