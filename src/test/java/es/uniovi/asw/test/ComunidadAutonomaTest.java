package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;
import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.ComunidadAutonoma;

public class ComunidadAutonomaTest {

	@Test
	public void test() {
		ComunidadAutonoma c= new ComunidadAutonoma((long)1, "c1");
		assertEquals("c1", c.getNombre());
		c.setNombre("c2");
		assertEquals("c2", c.getNombre());
		assertEquals("1", Long.toString(c.getId()));
		c.setId((long)2);
		assertEquals("2", Long.toString(c.getId()));
		
		c= new ComunidadAutonoma();
		c.setNombre("Principado de Asturias");
		boolean guardado= Factories.service.createComunidadAutonomaService().save(c);
		assertEquals(true,guardado);
		
		ComunidadAutonoma aux = Factories.service.createComunidadAutonomaService().findById((long)1);
		
		assertEquals("Principado de Asturias",aux.getNombre());
		
		
	}

}
