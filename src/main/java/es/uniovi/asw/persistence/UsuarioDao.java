package es.uniovi.asw.persistence;

import java.util.List;
import es.uniovi.asw.model.Usuario;

/**
 * Interfaz de la fachada a servicios de persistencia para la entidad Alumno.
 * 
 * En esta versi��n aparecen los otros m��todos b��sicos de un servicio 
 * de persistencia
 * 
 * @author dario
 *
 */
public interface UsuarioDao {

	List<Usuario> getUsuarios();
	
	boolean save(Usuario a) ;
		
	Usuario findByNIF(String login) ;
	
	Usuario findById(int id);
	

}