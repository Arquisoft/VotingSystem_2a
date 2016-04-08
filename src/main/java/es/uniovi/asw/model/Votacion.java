package es.uniovi.asw.model;

public class Votacion {
	
	private Long id;
	private String definicion;
	
	public Votacion(){};
	
	public Long getId() {
		
		return id;
		
	}

	public void setId(Long id) {
		
		this.id = id;
		
	}
	
	public String getDefinicion() {
		
		return definicion;
		
	}

	public void setDefinicion(String definicion) {
		
		this.definicion = definicion;
		
	}
	
}
