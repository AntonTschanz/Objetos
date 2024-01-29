package AuricularesAPP;

import java.io.*;
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
				aumentarPrecio(sc, listaAuriculares);
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

	private static void aumentarPrecio(Scanner sc, ArrayList<Auricular> listaAuriculares) {
		boolean marcaId = false, modeloId = false;
		int cambio = 0;
		
		System.out.print("========================================== \n"
				+ "Introduce las especificaciones del auricular.  \n"
				+ "Marca: ");
		String marca = sc.next();
		
		while (marcaId == false) {
			for (int i = 0; i < listaAuriculares.size(); i++) {
				if (listaAuriculares.get(i).getMarca().equalsIgnoreCase(marca)) {
					marcaId = true;
				}
			}
			
			if (marcaId == false) {
				System.out.print("Marca no encontrada, pruebe otra vez: ");
				marca = sc.next();
			}
		}
		System.out.print("Modelo: ");
		String modelo = sc.next();
		
		while (modeloId == false) {
			for (int x = 0; x < listaAuriculares.size(); x++) {

				if (listaAuriculares.get(x).getModelo().equalsIgnoreCase(modelo)) {
					modeloId = true;
					cambio = x;
				}
			}

			if (modeloId == false) {
				System.out.print("Modelo no encontrado, pruebe otra vez: ");
				modelo = sc.next();
			}
		}
		
		System.out.println("Se le han sumado 10€.");
		System.out.println(listaAuriculares.get(cambio).getPrecio() + " ====> "
				+ (listaAuriculares.get(cambio).getPrecio() + 10));

		listaAuriculares.get(cambio).setPrecio(listaAuriculares.get(cambio).getPrecio() + 10);
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
