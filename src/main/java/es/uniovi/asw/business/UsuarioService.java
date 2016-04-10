package es.uniovi.asw.business;

import es.uniovi.asw.model.Usuario;

public interface UsuarioService {

	
	Usuario findByNif(String nif);
	boolean saveUser(Usuario usuario) ;
	boolean puedeVotar (Usuario usuario);
	
}
