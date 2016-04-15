package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Voto;

public interface VotoDao {
	
	boolean save(Voto voto);
	boolean update(Voto voto);
	Voto find(Long idOpcion,Long idColElect);
	boolean incrementarVoto(Voto voto);
	
}
