package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.ColegioElectoral;

public class SaveCol {

	public boolean save(ColegioElectoral col) {

		return Factories.persistence.createColegioElectoralDao().save(col);
		
	}

}
