package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Usuario;

public class SaveUser {
	
	public boolean saveUser(Usuario usuario){
		
		if(usuario != null){
			
			
			return Factories.persistence.createUsuarioDao().save(usuario);
				
		}
		return false;
	}

}
