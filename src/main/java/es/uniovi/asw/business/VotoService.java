package es.uniovi.asw.business;

import es.uniovi.asw.model.Voto;

public interface VotoService {

	Voto findById(Long idOpcion,Long idColegioElectoral);
	void saveVoto(Voto voto);
	void update (Voto voto);
	
}
