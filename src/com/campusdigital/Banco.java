package com.campusdigital;

/**
 * Clase que representa el banco y toda la operativa
 * 
 * @author Ángel Padilla
 */
public class Banco {

	/**
	 * Array de objetos tipo cuenta bancaria que guarda hasta 50 de las mismas.
	 */
	CuentaBancaria[] cuentas = new CuentaBancaria[100];
	/**
	 * variable que almacenara la posición del array
	 */
	int index = 0;

	/**
	 * Almacena en la estructura para almacenar datos una nueva cuenta bancaria
	 * 
	 * @param cb cuenta bancaria a guardar
	 * @return true | false repectivamente si la operación fue exitosa
	 */
	public boolean abrirCuenta(CuentaBancaria cb) {
		cuentas[index] = cb;
		if (cuentas[index] == cb) {
			index++;
			return true;
		}

		return false;
	}

	/**
	 * Recupera una lista con las cuentas almacenadas
	 * 
	 * @return array vacio si no hay cuentas, en caso contrario, con las cuentas
	 *         existentes
	 */
	public String[] listadoCuentas() {
		String[] listado = new String[index];
		for (int i = 0; i < index; i++) {
			CuentaBancaria cuentaBancaria = cuentas[i];
			listado[i] = cuentaBancaria.getTitular().devolverInfoString() +
					" con iban: " + cuentaBancaria.getIban() +
					" con saldo de: " +  cuentaBancaria.getSaldo();
		}
		return listado;
	}

	/**
	 * Recupera la información de una determinada cuenta
	 * 
	 * @param iban número de cuenta a buscar
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
	 * @param iban  número de cuenta a buscar
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
	 * @param iban  número de cuenta a buscar
	 * @param saldo
	 * @return
	 */
	public boolean retiradaCuenta(String iban, double saldo) {
		CuentaBancaria cuentaBancaria = this.existeIban(iban);
		if (cuentaBancaria != null) {
				cuentaBancaria.retirarSaldo(saldo);
				return true;
		}

		return false;
	}

	/**
	 * 
	 * @param iban número de cuenta a buscar
	 * @return el valor del saldo o -1 si no existe el iban
	 */
	public double obtenerSaldo(String iban) {
		CuentaBancaria cuentaBancaria = this.existeIban(iban);
		if (cuentaBancaria != null) {
			return cuentaBancaria.getSaldo();
		}
		return -1;
	}

	/**
	 * Comprueba que existe el iban introducido
	 * 
	 * @param iban número de cuenta a buscar
	 * @return CuentaBancaria | null si existe o no respectivamente
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
