package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.ComunidadAutonomaService;
import es.uniovi.asw.business.impl.classes.FindComunidadAutonoma;
import es.uniovi.asw.business.impl.classes.SaveCom;
import es.uniovi.asw.model.ComunidadAutonoma;

public class SimpleComunidadAutonomaService implements ComunidadAutonomaService {

	@Override
	public ComunidadAutonoma findById(Long idComunidadAutonoma) {

		return new FindComunidadAutonoma().findById(idComunidadAutonoma);
		
	}

	@Override
	public boolean save(ComunidadAutonoma com) {
		
		return new SaveCom().save(com);
		
	}

}
