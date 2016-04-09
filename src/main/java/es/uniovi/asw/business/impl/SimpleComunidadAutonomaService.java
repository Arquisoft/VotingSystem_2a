package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.ComunidadAutonomaService;
import es.uniovi.asw.business.impl.classes.FindComunidadAutonoma;
import es.uniovi.asw.model.ComunidadAutonoma;

public class SimpleComunidadAutonomaService implements ComunidadAutonomaService {

	@Override
	public ComunidadAutonoma findById(long idComunidadAutonoma) {
		// TODO Auto-generated method stub
		return new FindComunidadAutonoma().findById(idComunidadAutonoma);
	}

}
