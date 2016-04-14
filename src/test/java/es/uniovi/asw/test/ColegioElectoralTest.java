package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.ColegioElectoral;

public class ColegioElectoralTest {

	@Test
	public void test() {
		ColegioElectoral c= new ColegioElectoral((long)1, (long)1, (long)1);
		assertEquals("1", Long.toString(c.getId()));
		c.setId((long)2);
		assertEquals("2", Long.toString(c.getId()));
		
		assertEquals("1", Long.toString(c.getIdCircunscripcion()));
		c.setIdCircunscripcion((long)2);
		assertEquals("2", Long.toString(c.getIdCircunscripcion()));
		
		assertEquals("1", Long.toString(c.getIdComAutonoma()));
		c.setIdComAutonoma((long)2);
		assertEquals("2", Long.toString(c.getIdComAutonoma()));
		
		boolean guardado= Factories.persistence.createColegioElectoralDao().save(c);
		assertEquals(true, guardado);
		
		assertEquals(c,Factories.persistence.createCircunscripcionDao().findById((long)2));
		
	}

}
