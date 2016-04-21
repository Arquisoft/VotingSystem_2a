package es.uniovi.asw.test;

import static org.junit.Assert.*;

import org.junit.Test;
import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.ComunidadAutonoma;
import es.uniovi.asw.presentacion.BeanColegioElectoral;
import es.uniovi.asw.presentacion.BeanOpcion;
import es.uniovi.asw.presentacion.BeanUsuarios;
import es.uniovi.asw.presentacion.BeanVotacion;
import es.uniovi.asw.presentacion.BeanVotaciones;

public class ComunidadAutonomaTest {

	@Test
	public void test() {
		ComunidadAutonoma c= new ComunidadAutonoma((long)1, "c1");
		assertEquals("c1", c.getNombre());
		c.setNombre("c2");
		assertEquals("c2", c.getNombre());
		assertEquals("1", Long.toString(c.getId()));
		c.setId((long)2);
		assertEquals("2", Long.toString(c.getId()));
		
		c= new ComunidadAutonoma();
		c.setNombre("Principado de Asturias");
		boolean guardado= Factories.service.createComunidadAutonomaService().save(c);
		assertEquals(true,guardado);
		
		ComunidadAutonoma aux = Factories.service.createComunidadAutonomaService().findById((long)1);
		
		assertEquals("Principado de Asturias",aux.getNombre());
		assertEquals(null,Factories.service.createComunidadAutonomaService().findById((long)1232525235));
		assertEquals(null,Factories.service.createComunidadAutonomaService().findById(null));
		
		BeanColegioElectoral bce = new BeanColegioElectoral();
		
		bce.setIdColegio("1");
		bce.setIdOpcion("1");
		bce.setNumVotos("1");
		
		assertEquals("1",bce.getIdColegio());
		assertEquals("1",bce.getIdOpcion());
		assertEquals("1",bce.getNumVotos());
		
		BeanOpcion bo= new BeanOpcion();
		bo.setIdOpcion("1");
		assertEquals("1",bo.getIdOpcion());
		
		BeanUsuarios bu= new BeanUsuarios();
		bu.setIdUsuario("1");
		assertEquals("1",bu.getIdUsuario());
		
		BeanVotacion bv= new BeanVotacion();
		bv.setDescripcion("1");
		bv.setFechaFin("1");
		bv.setFechaInicio("1");
		bv.setOpciones("1");
		assertEquals("1",bv.getDescripcion());
		assertEquals("1",bv.getFechaFin());
		assertEquals("1",bv.getFechaInicio());
		assertEquals("1",bv.getOpciones());
		
		BeanVotaciones bvs = new BeanVotaciones();
		bvs.setIdVotacion("1");
		assertEquals("1", bvs.getIdVotacion());
		
		
	}

}
