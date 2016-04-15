package es.uniovi.asw.business;

import es.uniovi.asw.model.Voto;

public interface VotoService {

	Voto findById(Long idOpcion,Long idColegioElectoral);
	boolean saveVoto(Voto voto);
	boolean update (Voto voto);
	boolean incrementarVoto (Voto voto);
	
}
