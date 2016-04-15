package es.uniovi.asw.business.impl.classes;

import java.util.List;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Usuario;

public class ListadoUsuarios {
	
	public List<Usuario> listadoUsuarios(){
		
		return Factories.persistence.createUsuarioDao().getUsuarios();
		
	}

}
