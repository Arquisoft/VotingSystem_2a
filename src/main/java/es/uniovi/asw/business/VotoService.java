package es.uniovi.asw.business;

import es.uniovi.asw.model.Voto;

public interface VotoService {

	Voto findById(long idOpcion,long idColegioElectoral);
	void SaveVoto(Voto voto);
	void Update (Voto voto);
	
}
