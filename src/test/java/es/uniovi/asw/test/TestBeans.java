package es.uniovi.asw.test;

import static org.junit.Assert.*;



import org.junit.Test;
import es.uniovi.asw.presentacion.BeanColegioElectoral;
import es.uniovi.asw.presentacion.BeanOpcion;
import es.uniovi.asw.presentacion.BeanUsuarios;
import es.uniovi.asw.presentacion.BeanVotacion;
import es.uniovi.asw.presentacion.BeanVotaciones;

public class TestBeans {

	@Test
	public void test() {
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
