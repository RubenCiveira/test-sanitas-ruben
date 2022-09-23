package es.plexus.sanitas.test.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import es.plexus.sanitas.test.service.math.OperadorResta;
import es.plexus.sanitas.test.service.math.OperadorSuma;
import es.plexus.sanitas.test.service.math.OperandoNumerico;

class OperadoresTest {

  @Test
  void testRest() {
    OperadorResta op = new OperadorResta();
    assertEquals(BigDecimal.valueOf(5l), op.operar(
        new OperandoNumerico(12l), new OperandoNumerico(7l) ) );
    assertEquals(BigDecimal.ZERO, op.operar());
  }
  
  @Test
  void testSuma() {
    OperadorSuma op = new OperadorSuma();
    assertEquals(BigDecimal.valueOf(19l), op.operar(
        new OperandoNumerico(12l), new OperandoNumerico(7l) ) );
    assertEquals(BigDecimal.ZERO, op.operar());
  }
}
