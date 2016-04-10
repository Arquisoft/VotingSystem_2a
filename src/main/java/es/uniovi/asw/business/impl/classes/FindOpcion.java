package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Opcion;

public class FindOpcion {
	
	public Opcion findById(Long idOpcion){
		
	if(idOpcion!=null){
			
			return Factories.persistence.createOpcionDao()
					.findById(idOpcion);
			
		}
		
		return null;
		
	}

}
