package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Voto;

public class SaveVoto {
	
	public boolean guardarVoto(Voto voto){
		if(voto != null){
			Factories.service.createVotoService().saveVoto(voto);
			return true;
		}
		return false;
				
	}

}
