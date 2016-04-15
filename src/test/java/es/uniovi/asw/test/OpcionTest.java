package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;
import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Opcion;

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
		
		o= new Opcion();
		o.setIdVotacion((long)1);
		o.setDescripcion("PP");
		
		boolean guardado= Factories.service.createOpcionService().save(o);
		
		assertEquals(true,guardado);
		
		o= new Opcion();
		o.setIdVotacion((long)1);
		o.setDescripcion("PSOE");
		
		guardado= Factories.service.createOpcionService().save(o);
		
		assertEquals(true,guardado);
		
		Opcion aux=Factories.service.createOpcionService().findById((long)1);
		
		assertEquals("PP",aux.getDescripcion());
		
		assertEquals(2,Factories.service.createOpcionService().listadoOpciones((long)1).size());

		
	}

}
