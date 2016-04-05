package es.uniovi.asw.model;

public class Votado {
	
	private Long idVotacion;
	private Long idVotante;
	
	public Votado(Long idVotacion, Long idVotante) {
		
		this.idVotacion = idVotacion;
		this.idVotante = idVotante;
		
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
