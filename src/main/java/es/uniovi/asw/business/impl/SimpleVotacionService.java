package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.VotacionService;
import es.uniovi.asw.business.impl.classes.GetVotacion;
import es.uniovi.asw.business.impl.classes.ListadoOpciones;
import es.uniovi.asw.business.impl.classes.ListadoVotaciones;
import es.uniovi.asw.business.impl.classes.SaveVot;
import es.uniovi.asw.model.Votacion;

public class SimpleVotacionService implements VotacionService {
	
	@Override
	public Votacion getTipoVotacion(Long idVotacion) {
		
		return new GetVotacion().getVotacion(idVotacion);
		
	}

	@Override
	public boolean save(Votacion vot) {

		return new SaveVot().save(vot);
		
	}
	
	@Override
	public List<Votacion> listadoVotaciones(){
		
		return new ListadoVotaciones().listadoVotacion();
	}
}
