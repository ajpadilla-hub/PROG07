package com.campusdigital;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);

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

		        System.out.println("Seleccione el tipo de cuenta:");
		        System.out.println("1. Cuenta de Ahorro");
		        System.out.println("2. Cuenta Corriente Personal");
		        System.out.println("3. Cuenta Corriente de Empresa");
		        int tipoCuenta = scanner.nextInt();
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

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

}