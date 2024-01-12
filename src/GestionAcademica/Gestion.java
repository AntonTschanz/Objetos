package GestionAcademica;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Curso c = new Curso("", "", "", null);
	ArrayList<Curso> listaCurso = new ArrayList<Curso>();
	ArrayList<Alumno> listaAlumno = new ArrayList<Alumno>();
	int opc;
	
	do {
		System.out.println("================= MENÚ ================= \n"
				+ "   1. Crear un nuevo estudiante. \n"
				+ "   2. Crear un nuevo Curso. \n"
				+ "   3. Mostrar información del Estudiante. \n"
				+ "   4. Mostrar información del Curso. \n"
				+ "   5. Guardar información. \n"
				+ "   6. Salir. \n"
				+ "========================================");
		opc = sc.nextInt();
		// Cada case meterlo a un método e invocarlo
		switch (opc){
			case 1:
				System.out.println("=========");
				System.out.print("Nombre: ");
				String nombre = sc.next();
				System.out.print("Edad: ");
				int edad = sc.nextInt();
				System.out.print("Curso: ");
				String curso = sc.next();
				
				Alumno alumno = new Alumno(nombre, edad, curso);
				listaAlumno.add(alumno);
				
				System.out.println(listaAlumno.toString());
				
				break;
			case 2:
				System.out.print("Curso: ");
				curso = sc.next();
				System.out.print("Descripción: ");
				String descripcion = sc.next();
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			default:
				System.out.println("Opción no disponible, inténtalo de nuevo.");
		}
		
	} while(opc != 6);
	
	}
}