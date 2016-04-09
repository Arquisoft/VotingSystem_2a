package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.VotacionService;
import es.uniovi.asw.business.impl.classes.GetVotacion;
import es.uniovi.asw.model.Votacion;

public class SimpleVotacionService implements VotacionService {
	
	@Override
	public Votacion getTipoVotacion(Long idVotacion) {
		
		return new GetVotacion().getVotacion(idVotacion);
		
	}
}
