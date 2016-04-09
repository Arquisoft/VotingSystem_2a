package es.uniovi.asw.business;

import es.uniovi.asw.model.Usuario;

public interface UsuarioService {

	
	Usuario findById(long idUsuario);
	void saveUser(Usuario usuario) ;
	boolean puedeVotar (Usuario usuario);
	
}
