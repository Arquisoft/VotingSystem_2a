package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.OpcionService;
import es.uniovi.asw.business.impl.classes.FindOpcion;
import es.uniovi.asw.model.Opcion;

public class SimpleOpcionService implements OpcionService {

	@Override
	public Opcion findById(long idOpcion) {
		// TODO Auto-generated method stub
		return new FindOpcion().findById(idOpcion);
	}

	@Override
	public List<Opcion> listadoOpciones(long idVotacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
