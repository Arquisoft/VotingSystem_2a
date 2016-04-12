package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Voto;

public interface VotoDao {
	
	void save(Voto voto);
	void update(Voto voto);
	Voto find(Long idOpcion,Long idColElect);
	
}
