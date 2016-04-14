package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Circunscripcion;

public class SaveCirc {

	public boolean save(Circunscripcion circ) {
		
		return Factories.persistence.createCircunscripcionDao().save(circ);
		
	}

}
