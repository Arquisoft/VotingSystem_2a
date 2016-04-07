package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Circunscripcion;

public interface CircunscripcionDao {
	
	Circunscripcion findById(Long id);
	
}
