package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.VotadoService;
import es.uniovi.asw.business.impl.classes.SaveVotado;
import es.uniovi.asw.model.Votado;

public class SimpleVotadoService implements VotadoService {

	@Override
	public void votado(Votado votado) {

		new SaveVotado().votado(votado);
		
	}

}
