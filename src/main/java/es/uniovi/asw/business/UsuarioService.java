package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.model.Usuario;

public interface UsuarioService {

	
	Usuario findByNif(String nif);
	boolean saveUser(Usuario usuario) ;
	boolean puedeVotar (Usuario usuario);
	List<Usuario> listaUsuarios();
	Usuario findById(int id);
	
}
