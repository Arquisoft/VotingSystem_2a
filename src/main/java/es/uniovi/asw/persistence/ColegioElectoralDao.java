package es.uniovi.asw.persistence;

import es.uniovi.asw.model.ColegioElectoral;

public interface ColegioElectoralDao {
	
	void save(ColegioElectoral col);
	ColegioElectoral findById(Long id);
	void update(ColegioElectoral col);//metodo solo para actualizar si ya estan introducidos los votos realizados fisicamente en ese colegio electoral

	
}
