package GestionAcademica;


public class Gestion {

	public static void main(String[] args) {
		
	Curso redes = new Curso();
	Curso mates = new Curso();
	mates.setDescripcion("Hola");
	
	System.out.println(mates.anyadirAlumno());
	}
}