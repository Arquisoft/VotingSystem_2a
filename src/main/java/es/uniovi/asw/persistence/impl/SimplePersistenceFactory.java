package es.uniovi.asw.persistence.impl;

import es.uniovi.asw.persistence.CircunscripcionDao;
import es.uniovi.asw.persistence.ColegioElectoralDao;
import es.uniovi.asw.persistence.ComunidadAutonomaDao;
import es.uniovi.asw.persistence.OpcionDao;
import es.uniovi.asw.persistence.PersistenceFactory;
import es.uniovi.asw.persistence.UsuarioDao;
import es.uniovi.asw.persistence.VotacionDao;
import es.uniovi.asw.persistence.VotadoDao;
import es.uniovi.asw.persistence.VotoDao;

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

	@Override
	public CircunscripcionDao createCircunscripcionDao() {

		return new CircunscripcionJdbcDao();
		
	}

	@Override
	public ColegioElectoralDao createColegioElectoralDao() {

		return new ColegioElectoralJdbcDao();
		
	}

	@Override
	public ComunidadAutonomaDao createComunidadAutonomaDao() {
		
		return new ComunidadAutonomaJdbcDao();
		
	}

	@Override
	public OpcionDao createOpcionDao() {

		return new OpcionJdbcDao();
		
	}

	@Override
	public VotacionDao createVotacionDao() {

		return new VotacionJdbcDao();
		
	}

	@Override
	public VotadoDao createVotadoDao() {

		return new VotadoJdbcDao();
		
	}

	@Override
	public VotoDao createVotoDao() {

		return new VotoJdbcDao();
		
	}

}
