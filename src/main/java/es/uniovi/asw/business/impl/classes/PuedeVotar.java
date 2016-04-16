package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Usuario;

public class PuedeVotar {
	
	public boolean puedeVotar(Usuario usuario){
		
		if(usuario!=null){
			
				usuario = Factories.persistence.createUsuarioDao().
						findByNIF(usuario.getNIF());
				return usuario.isVotoElectronico();
					
			
		}
		
		return false;
		
				
	}

}
