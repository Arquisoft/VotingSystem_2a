package es.uniovi.asw.persistence;

import es.uniovi.asw.model.ColegioElectoral;

public interface ColegioElectoralDao {
	
	boolean save(ColegioElectoral col);
	ColegioElectoral findById(Long id);
	boolean update(ColegioElectoral col);//metodo solo para actualizar si ya estan introducidos los votos realizados fisicamente en ese colegio electoral

	
}
