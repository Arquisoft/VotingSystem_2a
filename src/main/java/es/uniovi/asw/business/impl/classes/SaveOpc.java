package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Opcion;

public class SaveOpc {

	public boolean save(Opcion op) {
		
		return Factories.persistence.createOpcionDao().save(op);
		
	}

}
