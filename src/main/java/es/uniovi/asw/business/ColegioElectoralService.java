package es.uniovi.asw.business;

import es.uniovi.asw.model.ColegioElectoral;

public interface ColegioElectoralService {

	ColegioElectoral findById(Long idColegioElectoral);

	boolean save(ColegioElectoral col);
	
}
