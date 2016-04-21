package es.uniovi.asw.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.model.Votado;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.presentacion.BeanColegioElectoral;
import es.uniovi.asw.presentacion.BeanOpcion;
import es.uniovi.asw.presentacion.BeanUsuarios;
import es.uniovi.asw.presentacion.BeanVotacion;
import es.uniovi.asw.presentacion.BeanVotaciones;


@Controller
@SessionAttributes("vot")
public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	private BeanVotacion votacion= new BeanVotacion();
	private BeanUsuarios usuario = new BeanUsuarios();
	private BeanVotaciones votaciones= new BeanVotaciones();
	private BeanOpcion opcion= new BeanOpcion();
	//private BeanColegioElectoral colegio= new BeanColegioElectoral();

	private Usuario user;
	
	private boolean precargado=false;	
	
	@RequestMapping("/")
	public ModelAndView index(Model model) {
		precargar();
		
		LOG.info("Index page access");
		
		model.addAttribute("vot", usuario);
		
		return new ModelAndView("index");
		
	}
	
	@RequestMapping(value="/irVotaciones",method= RequestMethod.POST)
	public ModelAndView votaciones(BeanUsuarios usuario,Model model) {

		LOG.info("Votaciones page access");
		
		user= Factories.service.createUsuarioService().findById(Integer.valueOf(usuario.getIdUsuario()));
		
		if(user==null){
			return new ModelAndView("errorInicio");//voy a error si el id de usuario no esta en la bd
		}
		
		this.usuario.setIdUsuario(usuario.getIdUsuario());
		
		
		List <Votacion> listaVotaciones=new ArrayList<Votacion>();
		
		listaVotaciones= Factories.service.createVotacionService().listadoVotaciones();

		model.addAttribute("votaciones", listaVotaciones);
		model.addAttribute("vot", votaciones);
		
		return new ModelAndView("votaciones");
		
	}
	@RequestMapping(value="/irVotaciones",method= RequestMethod.GET)
	public ModelAndView votaciones(Model model) {

		LOG.info("Votaciones page access");
		
		user= Factories.service.createUsuarioService().findById(Integer.valueOf(usuario.getIdUsuario()));
		
		if(user==null){
			return new ModelAndView("errorInicio");//voy a error si el id de usuario no esta en la bd
		}
		
		this.usuario.setIdUsuario(usuario.getIdUsuario());
		
		
		List <Votacion> listaVotaciones=new ArrayList<Votacion>();
		
		listaVotaciones= Factories.service.createVotacionService().listadoVotaciones();

		model.addAttribute("votaciones", listaVotaciones);
		model.addAttribute("vot", votaciones);
		
		return new ModelAndView("votaciones");
		
	}

	private void precargar() {
		
		if(!precargado){
			
			Factories.service.precargaDeDatosService().precargaDeDatos();
			precargado=true;
			
		}
		
	}

	@RequestMapping(value="/votacion",method= RequestMethod.POST)
	public ModelAndView opciones(BeanVotaciones votaciones,Model model) {
		
		LOG.info("Votacion page access");
		
		boolean votado = Factories.service.createVotadoService()
		.haVotado((long)user.getId(), Long.valueOf(votaciones.getIdVotacion()));
		
		if(!votado){
		
			List<Opcion>listaOpciones = new ArrayList<Opcion>();
			
			Factories.service.createOpcionService()
			.listadoOpciones(Long.valueOf(votaciones.getIdVotacion()));
			Votacion v =Factories.service.createVotacionService()
					.getTipoVotacion(Long.valueOf(votaciones.getIdVotacion()));
			
			//Usuario u = Factories.service.createUsuarioService().findByNif(usuario)
			//System.out.println(v);
			
			if(v!=null){
				
				listaOpciones=Factories.service.createOpcionService()
					.listadoOpciones(v.getId());
				this.votaciones.setIdVotacion(votaciones.getIdVotacion());
				model.addAttribute("opciones", listaOpciones);
				model.addAttribute("vot", opcion);
				
				return new ModelAndView("votacion");
				
			}
			
			return new ModelAndView("errorEleccion");
			
		}
		
		return new ModelAndView("errorYaVotado");
		
	}
	
	@RequestMapping(value="/guardarVoto",method= RequestMethod.POST)
	public ModelAndView votar(BeanOpcion opcion,Model model) {
		
		LOG.info("Votacion page access");
		
		Opcion op = Factories.service.createOpcionService()
				.findById(Long.valueOf(opcion.getIdOpcion()));

		Long idVotacon = Long.valueOf(votaciones.getIdVotacion());
		
		if(op!=null && op.getIdVotacion().equals(idVotacon)){
			
			Voto v =Factories.service.createVotoService().findById(op.getId(), (long)user.getCodColElectoral());
			
			if(v==null){
				
				v= new Voto();
				v.setIdOpcion(op.getId());
				v.setIdColElect((long)user.getCodColElectoral());
				v.setTotVotos((long)1);
				
				Factories.service.createVotoService().saveVoto(v);
				
			}else{
				
				Factories.service.createVotoService().incrementarVoto(v);
				
			}
			
			Votado votado= new Votado(idVotacon, (long)user.getId());
			Factories.service.createVotadoService().votado(votado);
			
			return new ModelAndView("votar");
			
		}
			
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
		
		  SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 
		  Date fechaDateFin = null;
	      Date fechaDateInicio = null;

        try {
        	
        	
            fechaDateFin = formato.parse(votacion.getFechaFin());
			fechaDateInicio = formato.parse(votacion.getFechaInicio());
		} catch (ParseException e) {
			
			return new ModelAndView("errorCrearVotacion");
			
		}
	        
	    if(fechaDateInicio.after(fechaDateFin)){
	    	  
	    	 return new ModelAndView("errorCrearVotacion");
	    	  
	    }
		
		Votacion vot= new Votacion();
		vot.setDefinicion(votacion.getDescripcion());
		vot.setFechaFin(fechaDateFin);
		vot.setFechaInicio(fechaDateInicio);
		
		Factories.service.createVotacionService().save(vot);
		
		List<Votacion> lst =Factories.service.createVotacionService().listadoVotaciones();
		
		vot=lst.get(lst.size()-1);
		System.out.println(vot);
		String[] elems = votacion.getOpciones().split(";");
		
		
		
		for(int i=0;i<elems.length;i++){
			
			Opcion opc= new Opcion();
			opc.setDescripcion(elems[i]);
			opc.setIdVotacion(vot.getId());
			
			Factories.persistence.createOpcionDao().save(opc);
			
		}
		
		
		return new ModelAndView("votacionCreada");
		
	}
	
}