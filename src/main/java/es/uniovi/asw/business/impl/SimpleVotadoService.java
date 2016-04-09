package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.VotadoService;
import es.uniovi.asw.business.impl.classes.SaveVotado;

public class SimpleVotadoService implements VotadoService {

	

	@Override
	public void Votado(es.uniovi.asw.model.Votado votado) {
		// TODO Auto-generated method stub
		new SaveVotado().Votado(votado);
	}

}
