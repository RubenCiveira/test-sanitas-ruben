package es.plexus.sanitas.test.service.math;

import java.math.BigDecimal;

public class OperandoNumerico implements Operando {
  private final BigDecimal valor;

  public OperandoNumerico(BigDecimal valor) {
    super();
    this.valor = valor;
  }

  public OperandoNumerico(long valor) {
    super();
    this.valor = BigDecimal.valueOf(valor);
  }

  public OperandoNumerico(int valor) {
    super();
    this.valor = BigDecimal.valueOf(valor);
  }

  public OperandoNumerico(double valor) {
    super();
    this.valor = BigDecimal.valueOf(valor);
  }

  @Override
  public BigDecimal valor() {
    return valor;
  }

}
