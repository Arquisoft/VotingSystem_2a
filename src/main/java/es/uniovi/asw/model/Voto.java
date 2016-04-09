package es.uniovi.asw.model;

public class Voto {
	
	private Long idOpcion;
	private Long idColElect;
	private Long numVotos;
	
	
	public Voto(){
		
	};
	
	public Voto(Long idOpcion, Long idColElect, Long totVotos) {

		this.idOpcion = idOpcion;
		this.idColElect = idColElect;
		this.numVotos = totVotos;
		
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
		
		return numVotos;
		
	}
	
	public void setTotVotos(Long totVotos) {
		
		this.numVotos = totVotos;
		
	}
	
	
}
