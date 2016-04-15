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
		
		c=  new Voto();
		c.setIdOpcion((long)1);
		c.setIdColElect((long)1);
		c.setTotVotos((long)2);
		
		boolean guardado=Factories.service.createVotoService().saveVoto(c);
		assertEquals(true,guardado);
		
		Voto aux=Factories.service.createVotoService().findById((long)1, (long)1);
		assertEquals(2,(long)aux.getTotVotos());
		c.setTotVotos(c.getTotVotos()+1);
		
		Factories.service.createVotoService().update(c);
		aux = Factories.service.createVotoService().findById((long) 1, (long) 1);
		assertEquals(3, (long) aux.getTotVotos());

		assertEquals(true, Factories.service.createVotoService().incrementarVoto(aux));
		aux = Factories.service.createVotoService().findById((long) 1, (long) 1);

		assertEquals(4, (long) aux.getTotVotos());
		
	}

}
