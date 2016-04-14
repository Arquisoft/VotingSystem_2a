package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Circunscripcion;

public class CircunscripcionTest {

	@Test
	public void test() {
		Circunscripcion c= new Circunscripcion((long) 1, "c1");
		assertEquals("c1", c.getNombre());
		c.setNombre("c2");
		assertEquals("c2", c.getNombre());
		assertEquals("1", Long.toString(c.getId()));
		c.setId((long)3);
		assertEquals("3", Long.toString(c.getId()));
		
		Circunscripcion t = new Circunscripcion();
		t.setNombre("Instituto Jovellanos");
	
		boolean guardado=Factories.service.createCircunscripcionService().save(t); 
				//Factories.persistence.createCircunscripcionDao().save(t);
		
		assertEquals(true, guardado);
		Circunscripcion aux = Factories.service.createCircunscripcionService().findById((long)1);
		//System.out.println(aux.getNombre());
		assertEquals(t.getNombre(),aux.getNombre());
		
	}
}
