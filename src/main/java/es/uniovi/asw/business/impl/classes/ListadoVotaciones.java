package es.uniovi.asw.business.impl.classes;

import java.util.List;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Votacion;

public class ListadoVotaciones {
	
	public List<Votacion> listadoVotacion(){
		
		return  Factories.persistence.createVotacionDao().findAll();
		
	}

}
