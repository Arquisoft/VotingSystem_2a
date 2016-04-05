package es.uniovi.asw.persistence.impl;

import es.uniovi.asw.persistence.PersistenceFactory;
import es.uniovi.asw.persistence.UsuarioDao;

/**
 * Implementacion de la factoria que devuelve implementaci??????n de la capa
 * de persistencia con Jdbc 
 * 
 * @author Enrique
 *
 */
public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public UsuarioDao createUsuarioDao() {
		
		return new UsuarioJdbcDao();
		
	}


	

}
