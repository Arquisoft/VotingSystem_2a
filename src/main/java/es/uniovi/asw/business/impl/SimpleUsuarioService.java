package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.UsuarioService;
import es.uniovi.asw.business.impl.classes.FindUsuario;
import es.uniovi.asw.business.impl.classes.ListadoUsuarios;
import es.uniovi.asw.business.impl.classes.PuedeVotar;
import es.uniovi.asw.business.impl.classes.SaveUser;
import es.uniovi.asw.model.Usuario;

public class SimpleUsuarioService implements UsuarioService {

	@Override
	public Usuario findByNif(String nif) {

		return new FindUsuario().findByNif(nif);
		
	}

	@Override
	public boolean saveUser(Usuario usuario) {
		
		return new SaveUser().saveUser(usuario);

	}

	@Override
	public boolean puedeVotar(Usuario usuario) {

		return new PuedeVotar().puedeVotar(usuario);
		
	}
	
	@Override
	public List<Usuario> listaUsuarios() {

		return new ListadoUsuarios().listadoUsuarios();
		
	}

}
