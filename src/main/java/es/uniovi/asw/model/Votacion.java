package es.uniovi.asw.model;

import java.util.Date;

public class Votacion {
	
	private Long id;
	private String definicion;
	private Date fechaInicio;
	private Date fechaFin;
	
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	
	public Votacion() {
		
		
	}
	
	public Votacion(Long id, String definicion) {
		super();
		this.id = id;
		this.definicion = definicion;
	}
	
	public Votacion(Long id, String definicion,Date fechaInicio, Date fechaFin) {
		super();
		this.id = id;
		this.definicion = definicion;
		this.fechaInicio = fechaInicio;
		this.fechaFin=fechaFin;
	}


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
