package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Voto;

public class FindVoto {
	
	public Voto findById(Long idOpcion, Long idColegioElectoral){
		
		if(idOpcion!=null && idColegioElectoral != null){
			
			return Factories.persistence.createVotoDao()
					.find(idOpcion, idColegioElectoral);
			
		}
		
		return null;
		
		
	}

}
