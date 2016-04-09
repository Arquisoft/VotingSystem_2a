package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.VotoService;
import es.uniovi.asw.business.impl.classes.FindVoto;
import es.uniovi.asw.business.impl.classes.SaveVoto;
import es.uniovi.asw.business.impl.classes.UpdateVoto;
import es.uniovi.asw.model.Voto;

public class SimpleVotoService implements VotoService {

	@Override
	public Voto findById(long idOpcion, long idColegioElectoral) {
	
		return new FindVoto().findById(idOpcion, idColegioElectoral);
	}

	@Override
	public void SaveVoto(Voto voto) {
		
		new SaveVoto().guardarVoto(voto);
	}

	@Override
	public void Update(Voto voto) {
	
		new UpdateVoto().update(voto);
	}

}