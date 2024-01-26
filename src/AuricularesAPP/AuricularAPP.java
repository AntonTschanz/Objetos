package AuricularesAPP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AuricularAPP {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		File file = new File("src/AuricularesAPP/auriculares.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String lector = "";
		String[] Partes;
		ArrayList<Auricular> listaAuriculares = new ArrayList<Auricular>();
		
		while ((lector = br.readLine()) != null) {
			Auricular auricular = new Auricular();
			
			Partes = lector.split(";");
			auricular.setModelo(Partes[0]);
			auricular.setMarca(Partes[1]);
			auricular.setPrecio(Double.parseDouble(Partes[2]));
			auricular.setStock(Integer.parseInt(Partes[3]));
			
			listaAuriculares.add(auricular);
		}
		
		int opc;
		
		do {
			System.out.println("================== MENÚ ================== \n"
					+ "   1. Aumentar precio de auricular en 10 €. \n"
					+ "   2. Guardar los datos en un archivo. \n"
					+ "   3. Salir. \n"
					+ "==========================================");
			opc = sc.nextInt();
			switch (opc){
			case 1:
				System.out.print("Introduce las especificaciones del auricular.  \n"
						+ "Marca: ");
				String marca = sc.next();
				System.out.print("Modelo: ");
				String modelo = sc.next();
				
				break;
			case 2:
				guardar(listaAuriculares);
				break;
			case 3:
				System.out.println("¡Hasta la próxima!");
				break;
			default:
				System.out.println("Opción no disponible, inténtelo de nuevo.");
			}
			
		} while(opc != 3);
		
	}

	private static void guardar(ArrayList<Auricular> listaAuriculares) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/AuricularesAPP/auriculares.txt"));
		
		for(int i = 0; i < listaAuriculares.size(); i++) {
			bw.write(listaAuriculares.get(i).getModelo() + ";" + listaAuriculares.get(i).getMarca() + ";" 
		+ listaAuriculares.get(i).getPrecio() + ";" + listaAuriculares.get(i).getStock() + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}
