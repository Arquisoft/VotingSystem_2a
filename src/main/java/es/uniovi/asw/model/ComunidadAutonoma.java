package es.uniovi.asw.model;

public class ComunidadAutonoma {
	
	private Long id;
	private String nombre;
	
	public ComunidadAutonoma(){};
	public ComunidadAutonoma(Long id, String nombre) {

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
