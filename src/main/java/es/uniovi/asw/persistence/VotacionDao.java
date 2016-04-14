package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Votacion;

public interface VotacionDao {
	
	public boolean save(Votacion votacion);
	public Votacion findById(Long id);
	
}
