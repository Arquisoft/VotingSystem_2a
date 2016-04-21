package es.uniovi.asw.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.presentacion.BeanUsuarios;
import es.uniovi.asw.presentacion.BeanVotacion;
import es.uniovi.asw.presentacion.BeanVotaciones;


@Controller
@SessionAttributes("vot")
public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	BeanVotacion votacion= new BeanVotacion();
	BeanUsuarios usuarios = new BeanUsuarios();
	BeanVotaciones votaciones= new BeanVotaciones();
		
	@RequestMapping("/votaciones")
	public ModelAndView votaciones(Model model) {

		LOG.info("Votaciones page access");
				
		List <Votacion> listaVotaciones=new ArrayList<Votacion>();
	
		listaVotaciones.add(new Votacion((long)1, "Elecciones al Senado"));
		listaVotaciones.add(new Votacion((long)2, "Elecciones al Congreso"));
		listaVotaciones.add(new Votacion((long)3, "Referendum"));
		
		//listaVotaciones= Factories.service.createVotacionService().listadoVotaciones();
		System.out.println(listaVotaciones.size());
		model.addAttribute("votaciones", listaVotaciones);
		model.addAttribute("vot", votaciones);
		
		return new ModelAndView("votaciones");
		
	}

	@RequestMapping(value="/votacion",method= RequestMethod.POST)
	public ModelAndView opciones(BeanVotaciones votaciones, BeanUsuarios usuario,Model model) {
		
		LOG.info("Votacion page access");
		
		List<Opcion>listaOpciones = new ArrayList<Opcion>();
		listaOpciones.add(new Opcion((long)1 , (long)2, "Mariano Rajoy"));
		listaOpciones.add(new Opcion((long)1 , (long)2, "Albert Rivera"));
		listaOpciones.add(new Opcion((long)1 , (long)2, "Pedro Sanchez"));
		listaOpciones.add(new Opcion((long)1 , (long)2, "Pablo Iglesias"));
		
		Factories.service.createOpcionService()
		.listadoOpciones(Long.valueOf(votaciones.getIdVotacion()));
		Votacion v =Factories.service.createVotacionService()
				.getTipoVotacion(Long.valueOf(votaciones.getIdVotacion()));
		
		//Usuario u = Factories.service.createUsuarioService().findByNif(usuario)
		//System.out.println(v);
		
		if(v!=null){
		//if(v!=null){
			model.addAttribute("opciones", listaOpciones);
			model.addAttribute("vot", votaciones);
			return new ModelAndView("votacion");
			
		}
	
		//System.out.println(votaciones.getIdVotacion());
		//model.addAttribute("vot", votaciones);
		
		return new ModelAndView("errorEleccion");
		
	}
	
	@RequestMapping(value="/admin")
	public ModelAndView admin(Model model) {
		
		LOG.info("Admin page access");
		
		model.addAttribute("vot", votacion);

		return new ModelAndView("admin");
		
	}
	
	@RequestMapping(value="/crearVotacion",method= RequestMethod.POST)
	public ModelAndView guardarVotacion(BeanVotacion votacion,Model model) {
		
		LOG.info("Admin page access");
		/*System.out.println(votacion.getDescripcion());
		System.out.println(votacion.getFechaFin());
		System.out.println(votacion.getFechaInicio());
		*/
		return new ModelAndView("votacionCreada");
		
	}
	
}