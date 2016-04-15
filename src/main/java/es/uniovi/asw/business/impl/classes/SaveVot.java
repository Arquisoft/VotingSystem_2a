package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Votacion;

public class SaveVot {

	public boolean save(Votacion vot) {

		return Factories.persistence.createVotacionDao().save(vot);
		
	}

}
