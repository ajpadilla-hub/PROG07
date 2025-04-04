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
				} while (ibanValido);
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
					nuevaCuenta = new CuentaAhorro(titular, iban, saldo, interes);
				} else if (tipoCuenta == 2) {
					System.out.print("Ingrese la comisión de mantenimiento: ");
					double comision = scanner.nextDouble();
					nuevaCuenta = new CuentaCorrientePersonal(titular, iban, saldo, "", comision);
				} else if (tipoCuenta == 3) {
					System.out.print("Ingrese el tipo de interés por descubierto: ");
					double interesDescubierto = scanner.nextDouble();
					System.out.print("Ingrese la comisión por descubierto: ");
					double comisionDescubierto = scanner.nextDouble();
					nuevaCuenta = new CuentaCorrienteEmpresa(titular, iban, saldo, "", interesDescubierto,
							comisionDescubierto);
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
				} while (ibanValido);
				
				if (b.informacionCuenta(iban) != null) {
					
				} else{
					
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
				} while (ibanValido);
				b.ingresoCuenta(iban, saldo);
				break;

			case 5:
				System.out.print("Saldo a retirar: ");
				saldo = scanner.nextDouble();
				scanner.nextLine();
				do {
					System.out.print("Ingrese el IBAN: ");
					iban = scanner.nextLine();
					ibanValido = validarIban(iban);
				} while (ibanValido);
				b.retiradaCuenta(iban, saldo);
				break;

			case 6:
				do {
					System.out.print("Ingrese el IBAN: ");
					iban = scanner.nextLine();
					ibanValido = validarIban(iban);
				} while (ibanValido);
				b.obtenerSaldo(iban);
				break;

			case 7:
				System.out.println("Gracias por su visita!");
				break;

			default:
				break;
			}

		} while (option != 0);
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