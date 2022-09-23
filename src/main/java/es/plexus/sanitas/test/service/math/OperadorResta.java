package es.plexus.sanitas.test.service.math;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("resta")
@Qualifier("resta")
public class OperadorResta implements Operador {
  @Override
  public BigDecimal operar(Operando... operadores) {
    BigDecimal result = BigDecimal.ZERO;
    if (operadores != null && operadores.length > 0) {
      result = operadores[0].valor();
      for (int i = 1; i < operadores.length; i++) {
        result = result.subtract(operadores[i].valor());
      }
    }
    return result;
  }
}
