package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.model.Opcion;

public interface OpcionService {
	
	List<Opcion> listadoOpciones(Long idVotacion);
	Opcion findById(Long idOpcion);
}
