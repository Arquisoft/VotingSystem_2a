package es.uniovi.asw.persistence;

/**
 * Interfaz de la factoria que suministra implementaciones reales de la fachada 
 * de persistencia para cada Entidad del Modelo (en este caso solo hay 
 * una: Usuario;)
 *  
 *
 */
public interface PersistenceFactory {
	
	 CircunscripcionDao createCircunscripcionDao();
	 ColegioElectoralDao createColegioElectoralDao();
	 ComunidadAutonomaDao createComunidadAutonomaDao();
	 OpcionDao createOpcionDao();
	 UsuarioDao createUsuarioDao();
	 VotacionDao createVotacionDao();
	 VotadoDao createVotadoDao();
	 VotoDao createVotoDao();
	
}

