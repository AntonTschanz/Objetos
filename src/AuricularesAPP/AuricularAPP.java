package AuricularesAPP;

import java.io.*;

public class AuricularAPP {

	public static void main(String[] args) throws IOException{
//		Cargar el arrayList de auriculares, leyendo la información del fichero .txt.
//		Aumentar el precio del auricular especificado por el usuario en 10 €.
//		Guardar los datos en un archivo

		File file = new File("src/AuricularesAPP/auriculares.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

//		String linea = "";
//		
//		while((linea = br.readLine()) != null) {
//			System.out.println(linea);
//		}
		
		
	}

}
