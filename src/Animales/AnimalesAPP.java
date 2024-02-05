package Animales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalesAPP {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		File file = new File("src/Animales/animales.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String lector = "";
		String[] partes;
		ArrayList<Animales> listaAnimales = new ArrayList<Animales>();

		while ((lector = br.readLine()) != null) {
			partes = lector.split("::");
			ArrayList<String> habitats = new ArrayList<String>();
			habitats.add(partes[3]);
			habitats.add(partes[4]);
			habitats.add(partes[5]);

			Animales animales = new Animales(partes[0], partes[1], Integer.parseInt(partes[2]), habitats);
			listaAnimales.add(animales);

		}

		int opc;

		do {
			System.out.println("================== MENÚ ================== \n" 
					+ "   1. Mostrar datos de 2 animales. \n"
					+ "   2. Mostrar el animal que vive más. \n"
					+ "   3. Mostrar el hábitat del animal seleccionado por el usuario. \n" 
					+ "   4. Salir. \n"
					+ "==========================================");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				mostrarDatos(listaAnimales);
				break;
			case 2:
				animalLongevo(listaAnimales);
				break;
			case 3:
				habitatAnimal(sc, listaAnimales);
				break;
			case 4:
				System.out.println("¡Hasta la próxima!");
				break;
			default:
				System.out.println("Opción no disponible, inténtelo de nuevo.");
			}

		} while (opc != 4);

	}

	private static void habitatAnimal(Scanner sc, ArrayList<Animales> listaAnimales) {
		System.out.print("Introduce un animal: ");
		String animalBusc = sc.next();
		boolean enc = false;
		String habitatsTexto = "";

		while (enc == false) {
			for (int i = 0; i < listaAnimales.size(); i++) {
				if (listaAnimales.get(i).getNombre().equalsIgnoreCase(animalBusc)) {
					enc = true;
					for (int x = 0; x < listaAnimales.get(i).getHabitat().size(); x++) {
						habitatsTexto += listaAnimales.get(i).getHabitat().get(x);

						if (x == 0) {
							habitatsTexto += ", ";
						} else if (x == 1) {
							habitatsTexto += " y ";
						}
					}
					break;
				}
			}

			if (enc == false) {
				System.out.print("Animal no encontrado, prueba otra vez: ");
				animalBusc = sc.next();
			} else {
				System.out.println("El " + animalBusc + " puede vivir en " + habitatsTexto + ".");
			}

		}
	}

	private static void animalLongevo(ArrayList<Animales> listaAnimales) {
		int numeroMayor = Integer.MIN_VALUE, animal = 0;

		for (int i = 0; i < listaAnimales.size(); i++) {
			if (numeroMayor < listaAnimales.get(i).getEdad()) {
				numeroMayor = listaAnimales.get(i).getEdad();
				animal = i;
			}
		}
		System.out.println("El animal que más vive es el " + listaAnimales.get(animal).getNombre() + ", que vive "
				+ numeroMayor + " años.");
	}

	private static void mostrarDatos(ArrayList<Animales> listaAnimales) {
		int aniAleatorio1, aniAleatorio2;

		aniAleatorio1 = (int) (Math.random() * 3 + 0);
		aniAleatorio2 = (int) (Math.random() * 3 + 0);

		while (aniAleatorio2 == aniAleatorio1) {
			aniAleatorio2 = (int) (Math.random() * 3 + 0);
		}

		System.out.println(listaAnimales.get(aniAleatorio1).toString());
		System.out.println(listaAnimales.get(aniAleatorio2).toString());
	}

}
