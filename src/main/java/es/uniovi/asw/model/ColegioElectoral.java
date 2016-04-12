package es.uniovi.asw.model;

public class ColegioElectoral {
	
	private Long id;
	private Long idCircunscripcion;
	private Long idPComAutonoma;
	private boolean votoFisico;
	
	public ColegioElectoral(){
		
	}
	
	public ColegioElectoral(Long id, Long idCircunscripcion, Long idPComAutonoma) {

		this.id = id;
		this.idCircunscripcion = idCircunscripcion;
		this.idPComAutonoma = idPComAutonoma;
		
	}
	
	public ColegioElectoral(Long id, Long idCircunscripcion, Long idPComAutonoma, boolean votoFisico) {
		super();
		this.id = id;
		this.idCircunscripcion = idCircunscripcion;
		this.idPComAutonoma = idPComAutonoma;
		this.votoFisico = votoFisico;
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

	public Long getIdComAutonoma() {
		
		return idPComAutonoma;
		
	}

	public void setIdComAutonoma(Long idPComAutonoma) {
		
		this.idPComAutonoma = idPComAutonoma;
		
	}

	public boolean isVotoFisico() {
		
		return votoFisico;
		
	}

	public void setVotoFisico(boolean votoFisico) {
		
		this.votoFisico = votoFisico;
		
	}
	
	
	
}
