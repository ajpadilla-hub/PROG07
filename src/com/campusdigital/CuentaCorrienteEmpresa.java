package com.campusdigital;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
	double tipoInteresDescubierto;
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

}
