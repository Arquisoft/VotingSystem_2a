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
	
		c= new Votado();
		c.setIdVotacion((long)1);
		c.setIdVotante((long)2);
		
		boolean guardado = Factories.service.createVotadoService().votado(c);
		assertEquals(true, guardado);
		
		boolean haVotado = Factories.service.createVotadoService().haVotado((long)2, (long)2);
		assertEquals(false,haVotado);
		haVotado = Factories.service.createVotadoService().haVotado((long)2, (long)1);
		assertEquals(true,haVotado);
		assertEquals(false,Factories.service.createVotadoService().votado(null));
		//assertEquals(false,Factories.service.createVotadoService().haVotado(null, null));
		
	}

}
