package es.uniovi.asw.business;

public interface ServiceFactory {
	
	CircunscripcionService createCircunscripcionService();
	ColegioElectoralService createColegioElectoralService();
	ComunidadAutonomaService createComunidadAutonomaService();
	OpcionService createOpcionService();
	UsuarioService createUsuarioService();
	VotacionService createVotacionService();
	VotadoService createVotadoService();
	VotoService createVotoService();
	
}
