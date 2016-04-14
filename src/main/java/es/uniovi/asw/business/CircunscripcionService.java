package es.uniovi.asw.business;

import es.uniovi.asw.model.Circunscripcion;

public interface CircunscripcionService {
	
	Circunscripcion findById(Long idCircunscripcion);
	boolean save(Circunscripcion circ);
	
}
