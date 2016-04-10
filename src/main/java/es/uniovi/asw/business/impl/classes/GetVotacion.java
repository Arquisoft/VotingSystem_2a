package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Votacion;

public class GetVotacion {
	
	public Votacion getVotacion(Long idVotacion){
		
		if(idVotacion!=null){
			
			return Factories.persistence.createVotacionDao()
					.findById(idVotacion);
			
		}
		
		return null;
		
		
	}

}
