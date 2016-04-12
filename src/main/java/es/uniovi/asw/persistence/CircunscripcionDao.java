package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Circunscripcion;

public interface CircunscripcionDao {
	
	void save(Circunscripcion circ);
	Circunscripcion findById(Long id);
	
}
