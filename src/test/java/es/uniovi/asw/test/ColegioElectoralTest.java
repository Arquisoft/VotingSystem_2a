package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;

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
		
		assertEquals("1", Long.toString(c.getIdPComAutonoma()));
		c.setIdPComAutonoma((long)2);
		assertEquals("2", Long.toString(c.getIdPComAutonoma()));
		
		
	}

}
