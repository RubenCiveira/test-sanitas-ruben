package es.plexus.sanitas.test.service.math;

import java.math.BigDecimal;

public interface Operando {
  /**
   * Un operando tiene un valor que se utiliza en operaciones
   * 
   * @return el valor para utilizar
   */
  public BigDecimal valor();
}
