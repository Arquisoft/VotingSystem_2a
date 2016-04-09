package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.UsuarioService;
import es.uniovi.asw.business.impl.classes.FindUsuario;
import es.uniovi.asw.business.impl.classes.PuedeVotar;
import es.uniovi.asw.business.impl.classes.SaveUser;
import es.uniovi.asw.model.Usuario;

public class SimpleUsuarioService implements UsuarioService {

	@Override
	public Usuario findById(long idUsuario) {
		// TODO Auto-generated method stub
		return new FindUsuario().findById(idUsuario);
	}

	@Override
	public void saveUser(Usuario usuario) {
		new SaveUser().saveUser(usuario);

	}

	@Override
	public boolean puedeVotar(Usuario usuario) {
		// TODO Auto-generated method stub
		return new PuedeVotar().puedeVotar(usuario);
	}

}