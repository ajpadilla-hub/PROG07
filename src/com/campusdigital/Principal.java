package com.campusdigital;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase donde se implementa todo el código de interacción con el usuario
 * (lectura de teclado y salida por pantalla)
 * 
 * @author Àngel Padilla
 */
public class Principal {

	/**
	 * Punto de entrada de la aplicación
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);
		String iban;
		String listadoEntidades;
		double saldo;
		boolean ibanValido;
		Banco b = new Banco();
		int option = 7;

		do {
			menu();
			option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 1:
				System.out.println("\nIngrese los datos del cliente:");
				System.out.print("Nombre: ");
				String nombre = scanner.nextLine();
				System.out.print("Apellidos: ");
				String apellidos = scanner.nextLine();
				System.out.print("DNI: ");
				String dni = scanner.nextLine();
				Persona titular = new Persona(nombre, apellidos, dni);
				do {
					System.out.print("Ingrese el IBAN: ");
					iban = scanner.nextLine();
					ibanValido = validarIban(iban);
				} while (!ibanValido);
				System.out.print("Saldo inicial: ");
				saldo = scanner.nextDouble();
				scanner.nextLine();

				System.out.println("Seleccione el tipo de cuenta:");
				System.out.println("1. Cuenta de Ahorro");
				System.out.println("2. Cuenta Corriente Personal");
				System.out.println("3. Cuenta Corriente de Empresa");
				int tipoCuenta = scanner.nextInt();
				scanner.nextLine();

				CuentaBancaria nuevaCuenta = null;

				if (tipoCuenta == 1) {
					System.out.print("Ingrese el tipo de interés anual: ");
					double interes = scanner.nextDouble();
					scanner.nextLine();
					nuevaCuenta = new CuentaAhorro(titular, iban, saldo, interes);
				} else if (tipoCuenta == 2) {
					System.out.print("Ingrese la comisión de mantenimiento: ");
					double comision = scanner.nextDouble();
					scanner.nextLine();

					System.out.print("Ingrese el listado de entidades: ");
					listadoEntidades = scanner.nextLine();
					nuevaCuenta = new CuentaCorrientePersonal(titular, iban, saldo, listadoEntidades, comision);
				} else if (tipoCuenta == 3) {
					System.out.print("Ingrese el tipo de interés por descubierto: ");
					double interesDescubierto = scanner.nextDouble();
					scanner.nextLine();
					System.out.print("Ingrese la comisión por descubierto: ");
					double comisionDescubierto = scanner.nextDouble();
					scanner.nextLine();
					System.out.print("Ingrese el máximo por descubierto: ");
					double maximoDescubierto = scanner.nextDouble();
					scanner.nextLine();
					System.out.print("Ingrese el listado de entidades: ");
					listadoEntidades = scanner.nextLine();
					nuevaCuenta = new CuentaCorrienteEmpresa(titular, iban, saldo, listadoEntidades, interesDescubierto,
							comisionDescubierto, maximoDescubierto);
				} else {
					System.out.println("Opción inválida.");
					break;
				}

				if (b.abrirCuenta(nuevaCuenta)) {
					System.out.println("Cuenta creada exitosamente.");
				} else {
					System.out.println("No se pudo crear la cuenta.");
				}
				break;

			case 2:
				String[] listaCuentas = b.listadoCuentas();
				for (int i = 0; i < listaCuentas.length; i++) {
					String infoCuenta = listaCuentas[i];
					System.out.println(infoCuenta);
				}
				break;

			case 3:
				do {
					System.out.print("Ingrese el IBAN: ");
					iban = scanner.nextLine();
					ibanValido = validarIban(iban);
				} while (!ibanValido);
				String resultado = b.informacionCuenta(iban);
				if (resultado != null) {
					System.out.println(resultado);
				} else {
					System.out.println("Cuenta no encontrada");
				}
				break;

			case 4:
				System.out.print("Saldo a ingresar: ");
				saldo = scanner.nextDouble();
				scanner.nextLine();
				do {
					System.out.print("Ingrese el IBAN: ");
					iban = scanner.nextLine();
					ibanValido = validarIban(iban);
				} while (!ibanValido);
				boolean resultadoIngreso = b.ingresoCuenta(iban, saldo);
				if (resultadoIngreso) {
					System.out.println("Su operación se ha realizado con éxito");
				} else {
					System.out.println("No se ha podido realizar la operación");
				}
				break;

			case 5:
				System.out.print("Saldo a retirar: ");
				saldo = scanner.nextDouble();
				scanner.nextLine();
				do {
					System.out.print("Ingrese el IBAN: ");
					iban = scanner.nextLine();
					ibanValido = validarIban(iban);
				} while (!ibanValido);
				boolean resultadoRetirada = b.retiradaCuenta(iban, saldo);
				if (resultadoRetirada) {
					System.out.println("Su operación se ha realizado con éxito");
				} else {
					System.out.println("No se ha podido realizar la operación");
				}

				break;

			case 6:
				do {
					System.out.print("Ingrese el IBAN: ");
					iban = scanner.nextLine();
					ibanValido = validarIban(iban);
				} while (!ibanValido);
				double resultadoSaldo = b.obtenerSaldo(iban);
				if (resultadoSaldo != -1) {
					System.out.println("Su saldo es de: " + resultadoSaldo + "€");
				} else {
					System.out.println("No se ha podido obtener el saldo");
				}

				break;

			case 7:
				System.out.println("Sesión finalizada!");
				break;
			default:
				break;
			}

		} while (option != 7);
		scanner.close();
	}

	/**
	 * Método que muestra por pantalla el menú
	 */
	public static void menu() {
		System.out.println("Escoja una acción:");
		System.out.println("1. Abrir una nueva cuenta.");
		System.out.println("2. Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).");
		System.out.println("3. Obtener los datos de una cuenta concreta.");
		System.out.println("4. Realizar un ingreso en una cuenta.");
		System.out.println("5. Retirar efectivo de una cuenta.");
		System.out.println("6. Consultar el saldo actual de una cuenta.");
		System.out.println("7. Salir de la aplicación.");
	}

	/**
	 * Método que valida el IBAN
	 */
	public static boolean validarIban(String iban) {
		String regex = "^ES\\d{20}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(iban);
		return m.matches();
	}

}