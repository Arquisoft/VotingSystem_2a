package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Voto;

public class UpdateVoto {
	
	public boolean update(Voto voto){
		if(voto != null){
			
			return Factories.persistence.createVotoDao().update(voto);
			
		}
			return false;	
	}

}
