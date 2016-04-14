package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.data.domain.Persistable;

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
		
		//boolean guardado= Factories.persistence.createOpcionDao().save(o);
		//assertEquals(true,guardado):
		assertEquals(o,Factories.persistence.createOpcionDao().findById((long)2));
	}

}
