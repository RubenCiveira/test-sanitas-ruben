package es.plexus.sanitas.test.service.math;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service("suma")
public class OperadorSuma implements Operador {
  @Override
  public BigDecimal operar(Operando... operadores) {
    BigDecimal result = BigDecimal.ZERO;
    if (operadores != null && operadores.length > 0) {
      for (int i = 0; i < operadores.length; i++) {
        result = result.add(operadores[i].valor());
      }
    }
    return result;
  }
}
