package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.ColegioElectoralService;
import es.uniovi.asw.business.impl.classes.FindColegioElectoral;
import es.uniovi.asw.business.impl.classes.SaveCol;
import es.uniovi.asw.model.ColegioElectoral;

public class SimpleColegioElectoralService implements ColegioElectoralService {

	@Override
	public ColegioElectoral findById(Long idColegioElectoral) {

		return new FindColegioElectoral().findById(idColegioElectoral);
		
	}

	@Override
	public boolean save(ColegioElectoral col) {

		return new SaveCol().save(col);
		
	}

}
