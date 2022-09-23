package es.plexus.sanitas.test.service.math;

import java.math.BigDecimal;

public interface Operador {
  
  /**
   * 
   * 
   * @param operadores
   * @return el resultado
   */
  public BigDecimal operar(Operando... operadores);
}
