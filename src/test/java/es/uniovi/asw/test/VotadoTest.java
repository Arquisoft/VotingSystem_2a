package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Votado;

public class VotadoTest {

	@Test
	public void test() {

		Votado c= new Votado((long)1, (long)1);
		assertEquals("1", Long.toString(c.getIdVotacion()));
		c.setIdVotacion((long)2);
		assertEquals("2", Long.toString(c.getIdVotacion()));
		
		assertEquals("1", Long.toString(c.getIdVotante()));
		c.setIdVotante((long)2);
		assertEquals("2", Long.toString(c.getIdVotante()));
	
		
		//boolean guardado = Factories.persistence.createVotadoDao().save(c);
		//assertEquals(true, guardado);
		
		boolean haVotado = Factories.persistence.createVotadoDao().haVotado((long)2, (long)2);
		assertEquals(true,haVotado);
		
	}

}
