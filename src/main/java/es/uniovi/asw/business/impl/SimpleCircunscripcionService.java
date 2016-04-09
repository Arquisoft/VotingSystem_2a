package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.CircunscripcionService;
import es.uniovi.asw.business.impl.classes.FindCircunscripcion;
import es.uniovi.asw.model.Circunscripcion;

public class SimpleCircunscripcionService implements CircunscripcionService {

	@Override
	public Circunscripcion findById(Long idCircunscripcion) {
		
		return new FindCircunscripcion().findById(idCircunscripcion);
	}

}
