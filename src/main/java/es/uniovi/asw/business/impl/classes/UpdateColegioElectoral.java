package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.ColegioElectoral;


public class UpdateColegioElectoral {
	
	public boolean updateColegioElectoral(ColegioElectoral colegioElectoral){
		if(colegioElectoral != null){
		
			return 	Factories.persistence.createColegioElectoralDao().update(colegioElectoral);
			
		}
			return false;	
	}

}
