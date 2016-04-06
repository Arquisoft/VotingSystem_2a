package es.uniovi.asw.model;

public class ColegioElectoral {
	
	private Long id;
	private Long idCircunscripcion;
	private Long idPComAutonoma;
	
	public ColegioElectoral(){
		
	}
	
	public ColegioElectoral(Long id, Long idCircunscripcion, Long idPComAutonoma) {

		this.id = id;
		this.idCircunscripcion = idCircunscripcion;
		this.idPComAutonoma = idPComAutonoma;
		
	}

	public Long getId() {
		
		return id;
		
	}

	public void setId(Long id) {
		
		this.id = id;
		
	}

	public Long getIdCircunscripcion() {
		
		return idCircunscripcion;
		
	}

	public void setIdCircunscripcion(Long idCircunscripcion) {
		
		this.idCircunscripcion = idCircunscripcion;
		
	}

	public Long getIdPComAutonoma() {
		
		return idPComAutonoma;
		
	}

	public void setIdPComAutonoma(Long idPComAutonoma) {
		
		this.idPComAutonoma = idPComAutonoma;
		
	}
	
}
