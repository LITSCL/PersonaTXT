package cl.inacap.personatxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Start {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		boolean salir = false;
		
		while (salir == false) {
			System.out.println("1. Ingresar persona");
			System.out.println("2. Mostrar personas");
			System.out.println("3. Salir");
			String opcion = sc.nextLine();
			
			switch (opcion) {
				case "1":
					ingresarPersona();
					break;
				case "2":
					mostrarPersonas();
					break;
				case "3":
					salir = true;
					break;
				default:
					System.out.println("Opción no valida");
					break;
			}	
		}
	}
	
	public static void ingresarPersona() {
		System.out.println("Ingrese el rut de la persona");
		String rut = sc.nextLine();
		System.out.println("Ingrese el nombre de la persona");
		String nombre = sc.nextLine();
		
		try {
			
			   BufferedWriter bw = new BufferedWriter(new FileWriter("Personas.txt", true)); //Aca se crea el archivo si es que no existe.
			   bw.write("Rut: " + rut + " Nombre: " + nombre + "\n"); //Escribe en el archivo y hace un salto de línea.
			   bw.flush();
			   bw.close();
			   
		} catch (Exception ex) {
			
		}
	}

	private static void mostrarPersonas() {
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("Personas.txt"));
			
			Scanner sc = new Scanner(br); //Se establece que se va a leer el archivo.
			while (sc.hasNextLine() == true){ //Se repite mientras aya una linea que leer.
				System.out.println(sc.nextLine());
			}
			sc.close();

		} catch (Exception ex) {
			
		}
	}
}
