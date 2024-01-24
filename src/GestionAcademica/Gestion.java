package GestionAcademica;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {

	public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
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
		switch (opc){
			case 1:
			Menu1(sc, listaAlumno);
				break;
			case 2:
			Menu2(sc, listaCurso, listaAlumno);
				break;
			case 3:
			Menu3(sc, listaAlumno);
				break;
			case 4:
			Menu4(sc, listaCurso);
				break;
			case 5:
			Menu5(listaAlumno, listaCurso);
				break;
			case 6:
				System.out.println("¡Hasta la próxima!");
				break;
			default:
				System.out.println("Opción no disponible, inténtalo de nuevo.");
		}
		
	} while(opc != 6);
	
	}

	private static void Menu5(ArrayList<Alumno> listaAlumno, ArrayList<Curso> listaCurso) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/GestionAcademica/Alumno.txt", false));
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("src/GestionAcademica/Curso.txt", false));
		
		for(int i = 0; i < listaAlumno.size(); i++) {
			bw.write(listaAlumno.get(i).getNombre() + "," + listaAlumno.get(i).getEdad() + "," + listaAlumno.get(i).getCurso() + "\n");
		}
		bw.flush();
		bw.close();
		
		
		for(int i = 0; i < listaCurso.size(); i++) {
			bw1.write(listaCurso.get(i).getTitulo() + ";" + listaCurso.get(i).getDescripcion() + ";" + listaCurso.get(i).getProfesor() + ";" + listaAlumno.get(i).getNombre() + "\n");
		}
		bw1.flush();
		bw1.close();
	}

	private static void Menu4(Scanner sc, ArrayList<Curso> listaCurso) {
		String nombre = "";
		boolean identificador = false;
		int numInfo = 0;
		do {
		System.out.println("Nombre del curso: ");
		nombre = sc.next();
			for(int i = 0; i<listaCurso.size(); i++) {
				if(listaCurso.get(i).getTitulo().equalsIgnoreCase(nombre)) {
					identificador = true;
					numInfo = i;
				}
			}
			if(identificador) {
				System.out.println(listaCurso.get(numInfo).toString());
			} else {
				System.out.println("Curso no encontrado, por favor pruebe otra vez.");
			}
		} while (!listaCurso.get(numInfo).getTitulo().equalsIgnoreCase(nombre));
	}

	private static void Menu3(Scanner sc, ArrayList<Alumno> listaAlumno) {
		String nombre = "";
		boolean identificador = false;
		int numInfo = 0;
		do {
		System.out.println("Nombre del alumno: ");
		nombre = sc.next();
			for(int i = 0; i<listaAlumno.size(); i++) {
				if(listaAlumno.get(i).getNombre().equalsIgnoreCase(nombre)) {
					identificador = true;
					numInfo = i;
				}
			}
			if(identificador) {
				System.out.println("Alumno encontrado: ");
				System.out.println(listaAlumno.get(numInfo).toString());
			} else {
				System.out.println("Alumno no encontrado, por favor pruebe otra vez.");
			}
		} while (!listaAlumno.get(numInfo).getNombre().equalsIgnoreCase(nombre));
	}

	private static void Menu2(Scanner sc, ArrayList<Curso> listaCurso, ArrayList<Alumno> listaAlumno) {
		System.out.println("=========");
		System.out.print("Curso: ");
		String curso = sc.next();
		System.out.print("Descripción: ");
		String descripcion = sc.nextLine();
		descripcion = sc.nextLine();
		System.out.println("Profesor: ");
		String profesor = sc.next();
		
		Curso c = new Curso(curso, descripcion, profesor, listaAlumno);
		listaCurso.add(c);
	}

	private static void Menu1(Scanner sc, ArrayList<Alumno> listaAlumno) {
		System.out.println("=========");
		System.out.print("Nombre: ");
		String nombre = sc.next();
		System.out.print("Edad: ");
		int edad = sc.nextInt();
		System.out.print("Curso: ");
		String curso = sc.next();
		
		Alumno alumno = new Alumno(nombre, edad, curso);
		listaAlumno.add(alumno);
	}
}