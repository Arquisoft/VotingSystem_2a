package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Usuario;

public class FindUsuario {
	
	public Usuario findByNif(String dni){
		
		if(dni!=null){		
			return Factories.persistence.createUsuarioDao().
					findByNIF(dni);
			
		}
		
		return null;
		
	}

}
