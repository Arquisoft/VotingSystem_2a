package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.model.Votacion;

public interface VotacionService {
	
	Votacion getTipoVotacion(Long idVotacion);

	boolean save(Votacion vot);

	List<Votacion> listadoVotaciones();
	
}
