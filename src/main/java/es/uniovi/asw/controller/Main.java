package es.uniovi.asw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
//@RequestMapping("/")
public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	@RequestMapping("/")
	public ModelAndView landing(Model model) {

		LOG.info("Landing page access");
		//return new ModelAndView("landing");
		return new ModelAndView("votaciones");
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