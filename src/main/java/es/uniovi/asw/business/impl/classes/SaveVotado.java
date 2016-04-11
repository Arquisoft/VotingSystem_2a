package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Votado;


public class SaveVotado {
	
	public boolean votado(Votado votado){
		
		if(votado != null){
			
			Factories.persistence.createVotadoDao().save(votado);
			return true;
			
		}
		
		return false;
				
	}

}
