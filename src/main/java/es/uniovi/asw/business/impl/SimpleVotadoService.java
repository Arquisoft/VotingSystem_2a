package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.VotadoService;
import es.uniovi.asw.business.impl.classes.HaVotado;
import es.uniovi.asw.business.impl.classes.SaveVotado;
import es.uniovi.asw.model.Votado;

public class SimpleVotadoService implements VotadoService {

	@Override
	public boolean votado(Votado votado) {

		return new SaveVotado().votado(votado);
		
	}

	@Override
	public boolean haVotado(Long idUser, Long idVotacion) {
		
		return new HaVotado().votado(idUser,idVotacion);
	}

}
