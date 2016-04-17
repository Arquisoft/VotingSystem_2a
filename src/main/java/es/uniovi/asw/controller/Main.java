package es.uniovi.asw.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;


@Controller
//@RequestMapping("/")
public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	@RequestMapping("/votaciones")
	public ModelAndView votaciones(Model model) {

		LOG.info("Votaciones page access");
		
		List <Votacion> listaVotaciones=new ArrayList<Votacion>();
	
		listaVotaciones.add(new Votacion((long)1, "Elecciones al Senado"));
		listaVotaciones.add(new Votacion((long)2, "Elecciones al Congreso"));
		listaVotaciones.add(new Votacion((long)3, "Referendum"));
		
		//listaVotaciones= Factories.service.createVotacionService().findAll();
		
		model.addAttribute("votaciones", listaVotaciones);
		
		return new ModelAndView("votaciones");
		
	}
	

	@RequestMapping("/votacion")
	public ModelAndView opciones(@ModelAttribute Votacion vot,Model model) {
		
		LOG.info("Votacion page access");
		
		List<Opcion>listaOpciones = new ArrayList<Opcion>();
		listaOpciones.add(new Opcion((long)1 , (long)2, "Mariano Rajoy"));
		listaOpciones.add(new Opcion((long)1 , (long)2, "Albert Rivera"));
		listaOpciones.add(new Opcion((long)1 , (long)2, "Pedro Sanchez"));
		listaOpciones.add(new Opcion((long)1 , (long)2, "Pablo Iglesias"));
		
		model.addAttribute("opciones", listaOpciones);

		model.addAttribute("vot", vot);
		
		return new ModelAndView("votacion");
		

	}
	
}