package es.uniovi.asw.model;

public class Circunscripcion {
	
	private Long id;
	private String nombre;
	
	public Circunscripcion(){};
	
	public Circunscripcion(Long id, String nombre) {

		this.id = id;
		this.nombre = nombre;
	
	}

	public Long getId() {
		
		return id;
		
	}

	public void setId(Long id) {
		
		this.id = id;
		
	}

	public String getNombre() {
		
		return nombre;
		
	}

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	}
	
}
