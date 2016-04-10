package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.ComunidadAutonoma;

public class FindComunidadAutonoma {
	
	public ComunidadAutonoma findById(Long idComunidadAutonoma){
	if(idComunidadAutonoma!=null){
			
			return Factories.persistence.createComunidadAutonomaDao()
					.findById(idComunidadAutonoma);
			
		}
		
		return null;
		
		
		
	}

}
