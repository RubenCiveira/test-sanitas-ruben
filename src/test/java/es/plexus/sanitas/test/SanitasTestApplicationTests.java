package es.plexus.sanitas.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ComponentScan(basePackages = "es.plexus.sanitas.test")
@AutoConfigureMockMvc
@ContextConfiguration(classes = {SanitasTestApplication.class})
@WebMvcTest
class SanitasTestApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void sumar() throws Exception {
    MvcResult result = mockMvc
        .perform(MockMvcRequestBuilders
            .get("/api/math/suma?first=2&second=3")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    String decimal = result.getResponse().getContentAsString();
    assertNotNull(decimal);
    assertEquals("5", decimal);
  }
  
  @Test
  public void restar() throws Exception {
    MvcResult result = mockMvc
        .perform(MockMvcRequestBuilders
            .get("/api/math/resta?first=12&second=3")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    String decimal = result.getResponse().getContentAsString();
    assertNotNull(decimal);
    assertEquals("9", decimal);
  }
}