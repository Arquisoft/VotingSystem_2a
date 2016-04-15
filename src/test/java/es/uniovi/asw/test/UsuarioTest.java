package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Usuario;

public class UsuarioTest {

	@Test
	public void test() {
		//Usuario u = new Usuario(nombre, email, NIF, password, codColElectoral, id, login);
		Usuario u = new Usuario("Victor", "user1@email.com", "71778298J", "a", 1, 1, "Victor");
		assertEquals("Victor", u.getNombre());
		u.setNombre("Dario");
		assertEquals("Dario", u.getNombre());
		assertEquals("Dario", u.getLogin());
		u.setLogin("F");
		assertEquals("F", u.getLogin());
		
		assertEquals("user1@email.com", u.getEmail());
		u.setEmail("user2@email.com");
		assertEquals("user2@email.com", u.getEmail());
		
		assertEquals("71778298J",u.getNIF());
		u.setNIF("71900054F");
		assertEquals("71900054F", u.getNIF());
		
		assertEquals("a", u.getPassword());
		u.setPassword("b");
		assertEquals("b", u.getPassword());
		
		assertEquals(1, u.getId());
		
		assertEquals(1, u.getCodColElectoral());
		u.setCodColElectoral(2);
		assertEquals(2, u.getCodColElectoral());
		
		
		u = new Usuario();
		u.setNombre("Dario");
		u.setLogin("Dario");
		u.setCodColElectoral(1);
		u.setEmail("user2@email.com");
		u.setVotoElectronico(true);
		
		u.setNIF("71900054F");
		
		
		boolean guardado= Factories.service.createUsuarioService().saveUser(u);
		assertEquals(true,Factories.service.createUsuarioService().puedeVotar(u));
		assertEquals(true, guardado);
		assertEquals(false,Factories.service.createUsuarioService().saveUser(null));
		assertEquals(false,Factories.service.createUsuarioService().puedeVotar(null));
		assertEquals(1,Factories.service.createUsuarioService().listaUsuarios().size());
		Usuario aux =  Factories.service.createUsuarioService().findByNif("71900054F");
		
		assertEquals("Dario",aux.getNombre());
		assertEquals(null,Factories.service.createUsuarioService().findByNif("11111111F"));
		assertEquals(null,Factories.service.createUsuarioService().findByNif(null));
	}

}
