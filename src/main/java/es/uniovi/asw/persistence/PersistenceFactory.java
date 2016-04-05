package es.uniovi.asw.persistence;


/**
 * Interfaz de la factoria que suministra implementaciones reales de la fachada 
 * de persistencia para cada Entidad del Modelo (en este caso solo hay 
 * una: Usuario;)
 *  
 *
 */
public interface PersistenceFactory {
	
	public UsuarioDao createUsuarioDao();
	
}

