package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Usuario;

public class FindUsuarioPorId {
	
	public Usuario findById(int id){
		
		if(id>0){		
			return Factories.persistence.createUsuarioDao().findById(id);
				
			
		}
		
		return null;
		
	}

}
