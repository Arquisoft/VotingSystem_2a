package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.ComunidadAutonoma;

public class SaveCom {

	public boolean save(ComunidadAutonoma com) {
		// TODO Auto-generated method stub
		return Factories.persistence.createComunidadAutonomaDao().save(com);
	}

}
