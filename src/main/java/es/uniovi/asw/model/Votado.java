package es.uniovi.asw.model;

import java.util.Date;

public class Votado {
	
	private Long idVotacion;
	private Long idVotante;
	public Date getHaVotado() {
		return haVotado;
	}
	public void setHaVotado(Date haVotado) {
		this.haVotado = haVotado;
	}

	private Date haVotado;
	
	
	public Votado(){
		haVotado = new Date();
	};
	public Votado(Long idVotacion, Long idVotante) {
		
		this.idVotacion = idVotacion;
		this.idVotante = idVotante;
		haVotado = new Date();
		
	}
	
public Votado(Long idVotacion, Long idVotante,Date haVotado) {
		
		this.idVotacion = idVotacion;
		this.idVotante = idVotante;
		this.haVotado = haVotado;
		
	}

	public Long getIdVotacion() {
		
		return idVotacion;
		
	}
	
	public void setIdVotacion(Long idVotacion) {
		
		this.idVotacion = idVotacion;
		
	}
	
	public Long getIdVotante() {
		
		return idVotante;
		
	}
	
	public void setIdVotante(Long idVotante) {
		
		this.idVotante = idVotante;
		
	}
	
}
