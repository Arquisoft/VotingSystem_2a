package es.uniovi.asw.business;

import es.uniovi.asw.model.ComunidadAutonoma;

public interface ComunidadAutonomaService {
	
	ComunidadAutonoma findById(Long idComunidadAutonoma);

	boolean save(ComunidadAutonoma com);
	
}
