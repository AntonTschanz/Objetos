package Persona;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
//		Persona p1 = new Persona("123456789A", "Anton", "Tschanz");
//		System.out.println(p1.getDni());
//		p1.setDni("123A");
//		System.out.println(p1.getDni());
//		
//		System.out.println(p1);
		
		Scanner sc = new Scanner(System.in);

// Array
		Persona[] listaPersonas = new Persona[3];
	
		System.out.println("Ingrese los datos de cada persona: ");
		
		for(int i = 0; i<listaPersonas.length; i++) {
			System.out.println("Persona " + (i+1) + ": ");
			System.out.print("DNI: ");
			String dni = sc.next();
			System.out.print("Nombre: ");
			String nombre = sc.next();
			System.out.print("Apellido: ");
			String apellido = sc.next();
			Persona p = new Persona(dni, nombre, apellido);
			listaPersonas[i] = p;
		}
		System.out.println(listaPersonas);
		for(int i = 0; i<listaPersonas.length; i++) {
			System.out.println(listaPersonas[i]);
		}
		
// ArrayList
		
	}

}
