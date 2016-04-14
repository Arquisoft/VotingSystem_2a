package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.factories.Factories;

public class HaVotado {

	public boolean votado(long idUser, long idVotacion) {

		return Factories.persistence.createVotadoDao()
				.haVotado(idUser, idVotacion);
		
	}

}
