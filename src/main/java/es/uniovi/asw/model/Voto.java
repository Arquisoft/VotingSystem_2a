package es.uniovi.asw.model;

public class Voto {
	
	private Long idOpcion;
	private Long idColElect;
	private Long totVotos;
	
	public Voto(Long idOpcion, Long idColElect, Long totVotos) {

		this.idOpcion = idOpcion;
		this.idColElect = idColElect;
		this.totVotos = totVotos;
		
	}

	public Long getIdOpcion() {
		
		return idOpcion;
		
	}
	
	public void setIdOpcion(Long idOpcion) {
		
		this.idOpcion = idOpcion;
		
	}
	
	public Long getIdColElect() {
		
		return idColElect;
		
	}
	
	public void setIdColElect(Long idColElect) {
		
		this.idColElect = idColElect;
		
	}
	
	public Long getTotVotos() {
		
		return totVotos;
		
	}
	
	public void setTotVotos(Long totVotos) {
		
		this.totVotos = totVotos;
		
	}
	
	
}
