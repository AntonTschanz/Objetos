package Persona;

public class Persona {
	private String Dni;
	private String nombre;
	private String apellido;
	
	// Para Autogenerar CONSTRUCTOR (Source -> Generate Constructor using Fields...)
	
	// El constructor siempre es public
	// El constructor te da la posibilidad de hacer "new Persona"
	public Persona(String dni, String nombre, String apellido) {
		this.Dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
	}
	
	// Para autogenerar los Getters y Setters (Source -> Generate Getters and Setters...)
	
	public String getDni() {
		return this.Dni;
	}
	public void setDni(String dni) {
		this.Dni=dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	
	// Para autogenerar el toString (Source -> Generate toString)
	
	@Override
	public String toString() {
		return "Mi nombre es " + this.nombre + ", mi apellido " + this.apellido + " y mi DNI es " + this.Dni;
	}
}
