package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Votacion;

public class VotacionTest {

	@Test
	public void test() {
		
		Votacion v = new Votacion((long)1,"Votacion al Senado");
		
		assertEquals("Votacion al Senado", v.getDefinicion());
		v.setDefinicion("Votacion al Congreso");
		assertEquals("Votacion al Congreso", v.getDefinicion());
		
		assertEquals("1", Long.toString(v.getId()));
		v.setId((long)2);
		assertEquals("2", Long.toString(v.getId()));
		
		v= new Votacion();
		v.setDefinicion("Votacion al Congreso");
		
		boolean guardado=Factories.service.createVotacionService().save(v);
		assertEquals(1,Factories.service.createVotacionService().listadoVotaciones().size());
		
		assertTrue(guardado);
		Factories.service.createVotacionService().getTipoVotacion((long)1);
		
		//assertEquals("Votacion al Congreso",aux.getDefinicion());
		assertEquals(null,Factories.service.createVotacionService().getTipoVotacion((long)1232525235));
		assertEquals(null,Factories.service.createVotacionService().getTipoVotacion(null));
		
	}

}
