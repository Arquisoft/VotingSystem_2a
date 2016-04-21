package es.uniovi.asw;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.uniovi.asw.controller.Main;
import es.uniovi.asw.presentacion.BeanUsuarios;
import scala.annotation.meta.setter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class MainControllerTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }
  
  @Test
  public void testIinicio() throws Exception {
    mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(containsString("Votacion")));
  }
  
  //@Test
  public void testVotaciones() throws Exception {
    mvc.perform(get("/irVotaciones")).andExpect(status().isOk()).andExpect(content().string(containsString("Votaciones")));
  }
  
  @Test
  public void testAdmin() throws Exception {
    mvc.perform(get("/admin")).andExpect(status().isOk()).andExpect(content().string(containsString("Votacion")));
  }
  
  @Test
  public void testColegio() throws Exception {
    mvc.perform(get("/colegio")).andExpect(status().isOk()).andExpect(content().string(containsString("Votacion")));
  }
  
  @Test
  public void testVotacion() throws Exception {
	Main m= new Main();
	BeanUsuarios user= new BeanUsuarios();
	user.setIdUsuario("1");
	m.setUsuario(user);
	
    mvc.perform(get("/irVotacion")).andExpect(status().isOk()).andExpect(content().string(containsString("Votacion")));
  }

}