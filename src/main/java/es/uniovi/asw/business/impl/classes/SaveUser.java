package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Usuario;

public class SaveUser {
	
	public boolean saveUser(Usuario usuario){
		
		if(usuario != null){
			
			Factories.persistence.createUsuarioDao().save(usuario);
			return true;
				
		}
		return false;
	}

}
