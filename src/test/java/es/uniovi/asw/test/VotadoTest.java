package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;

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
		
		
	}

}
