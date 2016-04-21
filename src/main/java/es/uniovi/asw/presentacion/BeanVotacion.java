package es.uniovi.asw.presentacion;

public class BeanVotacion {
	
	private String fechaInicio;
	private String fechaFin;
	private String descripcion;
	private String opciones;

	public BeanVotacion(){
		
	}
	
	public BeanVotacion(String fechaInicio, String fechaFin, String descripcion,String opciones) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public String getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOpciones() {
		return opciones;
	}

	public void setOpciones(String opciones) {
		this.opciones = opciones;
	}

}
