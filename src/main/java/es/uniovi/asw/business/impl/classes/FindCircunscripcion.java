package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Circunscripcion;

public class FindCircunscripcion {
	
	public Circunscripcion findById(Long idCircunscripcion){
		
		if(idCircunscripcion!=null){
			
			return Factories.persistence.createCircunscripcionDao()
					.findById(idCircunscripcion);
			
		}
		
		return null;
		
		
		
	}

}
