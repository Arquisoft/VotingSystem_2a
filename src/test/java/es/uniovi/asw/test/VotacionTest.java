package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Votacion;

public class VotacionTest {

	@Test
	public void test() {
		Votacion v = new Votacion();
		v.setDefinicion("Hola");
		assertEquals("Hola", v.getDefinicion());
		
		v.setId((long)1);
		assertEquals("1", Long.toString(v.getId()));
		
		//boolean guardado=Factories.persistence.createVotacionDao().save(v);
		assertEquals(v,Factories.persistence.createVotacionDao().findById((long)1));
	}

}
