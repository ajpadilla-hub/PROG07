package com.campusdigital;

/**
 * @author Ángel Padilla
 */
public class Banco {

	/**
	 * Array de objetos tipo cuenta bancaria que guarda hasta 50 de las mismas.
	 */
	CuentaBancaria[] cuentas = new CuentaBancaria[50];
	/**
	 * variable que almacenara la posición del array
	 * 
	 */
	int index = 0;

	/**
	 * Método que almacena en la estructura para almacenar
	 * datos una nueva cuenta bancaria
	 * @param cb
	 * @return true | false repectivamente si la operación
	 * fue exitosa
	 */
	public boolean abrirCuenta(CuentaBancaria cb) {
		cuentas[index] = cb;
		if (cuentas[index] == cb)
			return true;

		return false;
	}

	/**
	 * Método que recupera una lista con las cuentas almacenadas
	 * @return array vacio si no hay cuentas, en caso contrario, 
	 * con las cuentas existentes
	 */
	public String[] listadoCuentas() {
		String[] listado = new String[index + 1];
		for (int i = 0; i < index; i++) {
			CuentaBancaria cuentaBancaria = cuentas[i];
			listado[i] = cuentaBancaria.devolverInfoString();
		}
		return listado;
	}

	/**
	 * Método que recupera la información de una determinada cuenta
	 * @param iban
	 * @return null | String con los datos princpales de esa cuenta
	 */
	public String informacionCuenta(String iban) {
		CuentaBancaria cuentaBancaria = this.existeIban(iban);
		if (cuentaBancaria != null) {
			return cuentaBancaria.devolverInfoString();
		}
		return null;
	}

	/**
	 * 
	 * @param iban
	 * @param saldo
	 * @return
	 */
	public boolean ingresoCuenta(String iban, double saldo) {
		CuentaBancaria cuentaBancaria = this.existeIban(iban);
		if (cuentaBancaria != null) {
			cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() + saldo);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param iban
	 * @param saldo
	 * @return
	 */
	public boolean retiradaCuenta(String iban, double saldo) {
		CuentaBancaria cuentaBancaria = this.existeIban(iban);
		if (cuentaBancaria != null) {
			if (cuentaBancaria.getSaldo() > 0) {
				cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() - saldo);
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * @param iban
	 * @return
	 */
	public double obtenerSaldo(String iban) {
		CuentaBancaria cuentaBancaria = this.existeIban(iban);
		if (cuentaBancaria != null) {
			return cuentaBancaria.getSaldo();
		}
		return -1;
	}

	/**
	 * 
	 * @param iban
	 * @return
	 */
	private CuentaBancaria existeIban(String iban) {
		for (int i = 0; i < index; i++) {
			CuentaBancaria cuentaBancaria = cuentas[i];
			if (cuentaBancaria.getIban().equals(iban)) {
				return cuentaBancaria;
			}
		}
		return null;
	}
}
