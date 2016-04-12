package es.uniovi.asw.persistence;

import es.uniovi.asw.model.ComunidadAutonoma;

public interface ComunidadAutonomaDao {
	
	boolean save(ComunidadAutonoma com);
	ComunidadAutonoma findById(Long id);
	
}
