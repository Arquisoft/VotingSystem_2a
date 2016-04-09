package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.CircunscripcionService;
import es.uniovi.asw.business.ColegioElectoralService;
import es.uniovi.asw.business.ComunidadAutonomaService;
import es.uniovi.asw.business.OpcionService;
import es.uniovi.asw.business.ServiceFactory;
import es.uniovi.asw.business.UsuarioService;
import es.uniovi.asw.business.VotacionService;
import es.uniovi.asw.business.VotadoService;
import es.uniovi.asw.business.VotoService;

public class SimpleserviceFactory implements ServiceFactory {

	@Override
	public CircunscripcionService createCircunscripcionService() {

		return new SimpleCircunscripcionService();
		
	}

	@Override
	public ColegioElectoralService createColegioElectoralService() {

		return new SimpleColegioElectoralService();
		
	}

	@Override
	public ComunidadAutonomaService createComunidadAutonomaService() {

		return null;
		
	}

	@Override
	public OpcionService createOpcionService() {
		
		return null;
		
	}

	@Override
	public UsuarioService createUsuarioService() {

		return null;
		
	}

	@Override
	public VotacionService createVotacionService() {

		return null;
		
	}

	@Override
	public VotadoService createVotadoService() {

		return null;
		
	}

	@Override
	public VotoService createVotoService() {

		return null;
		
	}

}
