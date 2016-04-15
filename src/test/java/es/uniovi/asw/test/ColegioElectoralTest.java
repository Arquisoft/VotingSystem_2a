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
		
	
		ColegioElectoral c2= new ColegioElectoral();
		c2.setIdCircunscripcion((long)10);
		c2.setIdComAutonoma((long)13);
		boolean guardado= Factories.service.createColegioElectoralService().save(c2);
		assertEquals(true, guardado);
		
		ColegioElectoral aux=Factories.service.createColegioElectoralService().findById((long)1);
		aux.setVotoFisico(true);
		assertEquals(true, Factories.service.createColegioElectoralService().update(aux));
		
		aux=Factories.service.createColegioElectoralService().findById((long)1);
		assertTrue(aux.isVotoFisico());
		assertEquals(10, (long)aux.getIdCircunscripcion());
		assertEquals(13, (long)aux.getIdComAutonoma());
		assertEquals(null,Factories.service.createColegioElectoralService().findById((long)1232525235));
		assertEquals(null,Factories.service.createColegioElectoralService().findById(null));
		//assertEquals(null,Factories.service.createColegioElectoralService().update(null));
		
	}

}
