package es.uniovi.asw.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class OpcionTest {

	@Test
	public void test() {
		
		Opcion o= new Opcion((long)1, (long)1, "AlbertRivera");
		
		assertEquals("1", Long.toString(o.getId()));
		o.setId((long)2);
		assertEquals("2", Long.toString(o.getId()));
		
		assertEquals("1", Long.toString(o.getIdVotacion()));
		o.setIdVotacion((long)2);
		assertEquals("2", Long.toString(o.getIdVotacion()));
		
		assertEquals("AlbertRivera", o.getDescripcion());
		o.setDescripcion("Rajoy");
		assertEquals("Rajoy", o.getDescripcion());
	}

}
