package es.uniovi.asw.steps;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;

@ContextConfiguration(classes=Application.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class LandingSteps {
  /*
  @Autowired
  protected WebApplicationContext context;

  protected MockMvc mvc;
  protected MvcResult result;
  
  @Value("${local.server.port}")
  protected int port;

  
  @When("^the client calls /$")
  public void theClientCalls() throws Throwable {
    Assert.notNull(context);
    this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    result = mvc.perform(get("/")).andReturn();
  }

  @Then("^the client receives status code of (\\d+)$")
  public void theClientReceivesStatusCodeOf(int status) throws Throwable {
    assertThat(result.getResponse().getStatus(), is(status));
  }

  @Then("^the client receives the string \"([^\"]*)\"$")
  public void theClientReceivesTheString(String str) throws Throwable {
   assertThat(result.getResponse().getContentAsString(), containsString(str));
  }
*/
}
