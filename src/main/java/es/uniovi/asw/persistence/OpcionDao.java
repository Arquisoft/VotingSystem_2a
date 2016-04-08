package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Opcion;

public interface OpcionDao {

	public Opcion findById(Long id);
	public void save(Opcion opcion);
	public List<Opcion> listOpcionesByVotacion(Long idVotacion);
	
}
