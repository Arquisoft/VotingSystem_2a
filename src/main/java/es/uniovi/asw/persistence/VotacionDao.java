package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Votacion;

public interface VotacionDao {
	
	public boolean save(Votacion votacion);
	public Votacion findById(Long id);
	public List<Votacion> findAll();
	
}
