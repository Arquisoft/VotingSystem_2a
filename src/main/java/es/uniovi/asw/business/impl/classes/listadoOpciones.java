package es.uniovi.asw.business.impl.classes;

import java.util.List;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;

public class listadoOpciones {
	
	public List<Opcion> listadoVotacion(Long idVotacion){
		
		if(idVotacion!=null){
			
			return Factories.persistence.createOpcionDao().listOpcionesByVotacion(idVotacion);
			
		}
		
		return null;
		
		
	}

}
