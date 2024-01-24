package GestionAcademica;

import java.util.ArrayList;

public class Curso {	
	private String titulo;
	private String descripcion;
	private String profesor;
	private ArrayList<Alumno> listaAlumnos = new ArrayList<>();
	
//	public Curso() {
//		
//	}
	
	public Curso(String titulo, String descripcion, String profesor, ArrayList<Alumno> listaAlumnos) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.profesor = profesor;
		this.listaAlumnos = listaAlumnos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	

	// Método
	public void anyadirAlumno(Alumno a) {
		this.getListaAlumnos().add(a);
	}
	
	
	
	@Override
	public String toString() {
		return "Curso " + titulo + " es un " + descripcion + ", el profesor encargado es " +
				profesor + " y los alumnos dentro de este curso son los siguientes: " + listaAlumnos + ".";
	}

}
