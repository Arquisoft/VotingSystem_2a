package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Voto;

public class VotoTest {

	@Test
	public void test() {
	
		Voto c= new Voto((long)1, (long)1, (long)1);
		assertEquals("1", Long.toString(c.getIdColElect()));
		c.setIdColElect((long)2);
		assertEquals("2", Long.toString(c.getIdColElect()));
		
		assertEquals("1", Long.toString(c.getIdOpcion()));
		c.setIdOpcion((long)2);
		assertEquals("2", Long.toString(c.getIdOpcion()));
		
		assertEquals("1", Long.toString(c.getTotVotos()));
		c.setTotVotos((long)2);
		assertEquals("2", Long.toString(c.getTotVotos()));
		
		//boolean guardado=Factories.persistence.createVotoDao().save(c);
		//assertEquals(true,guardado);
		assertEquals(c,Factories.persistence.createVotoDao().find((long)2, (long)2));
		
	}

}
