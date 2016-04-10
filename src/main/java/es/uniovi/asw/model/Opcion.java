package es.uniovi.asw.model;

public class Opcion {
	
	private Long id;
	private Long idVotacion;
	private String descripcion;
	
	public Opcion(){
			
	}
	
	public Opcion(Long id, Long idVotacion, String descripcion) {

		this.id = id;
		this.idVotacion = idVotacion;
		this.descripcion = descripcion;
		
	}
	
	public Long getId() {
		
		return id;
		
	}
	
	public void setId(Long id) {
		
		this.id = id;
		
	}
	
	public Long getIdVotacion() {
		
		return idVotacion;
		
	}
	
	public void setIdVotacion(Long idVotacion) {
		
		this.idVotacion = idVotacion;
		
	}
	
	public String getDescripcion() {
		
		return descripcion;
		
	}
	
	public void setDescripcion(String descripcion){
		
		this.descripcion = descripcion;
		
	}
	
}
