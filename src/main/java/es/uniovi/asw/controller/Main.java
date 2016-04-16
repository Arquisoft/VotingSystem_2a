package es.uniovi.asw.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import es.uniovi.asw.model.Votacion;
import org.springframework.web.servlet.view.RedirectView;


@Controller
//@RequestMapping("/")
public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	
	@RequestMapping("/votaciones")
	public ModelAndView votaciones(Model model) {

		LOG.info("Votaciones page access");
		
		List <Votacion> listaVotaciones=new ArrayList<Votacion>();
		
		listaVotaciones.add(new Votacion((long)1, "PP"));
		listaVotaciones.add(new Votacion((long)2, "PSOE"));
		listaVotaciones.add(new Votacion((long)3, "Ciudadanos"));
		
		//listaVotaciones= Factories.service.createVotacionService().findAll();
		model.addAttribute("votaciones", listaVotaciones);
		
		return new ModelAndView("votaciones");
		
	}
	

	@RequestMapping("/votacion")
	public ModelAndView votacion(Model model) {

		LOG.info("Votacion page access");
		
		return new ModelAndView("votacion");
		

	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public RedirectView localRedirect() {
//	    RedirectView redirectView = new RedirectView();
//	    
//		redirectView.setUrl("votaciones.xhtml");
//
//	    return redirectView;
//	}

}