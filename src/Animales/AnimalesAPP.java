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
			
			Animales animales = new Animales(partes[0], partes [1], Integer.parseInt(partes[2]), habitats);
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
			switch (opc){
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				System.out.println("¡Hasta la próxima!");
				break;
			default:
				System.out.println("Opción no disponible, inténtelo de nuevo.");
			}
			
		} while(opc != 4);

	}

}
