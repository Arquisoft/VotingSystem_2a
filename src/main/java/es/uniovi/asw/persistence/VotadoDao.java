package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Votado;

public interface VotadoDao {
	
	public void save(Votado votado);
	public boolean haVotado(Long idUser,Long idVotacion);
	
}
