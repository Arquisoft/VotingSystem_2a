package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.ColegioElectoral;

public class FindColegioElectoral {
	
	public ColegioElectoral findById(Long idColegioElectoral){
		
		if(idColegioElectoral!=null){
			
			return Factories.persistence.createColegioElectoralDao()
					.findById(idColegioElectoral);
			
		}
		
		return null;
		
	}

}
