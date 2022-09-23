package es.plexus.sanitas.test.controller;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.plexus.sanitas.test.service.math.Operador;
import es.plexus.sanitas.test.service.math.OperandoNumerico;

@RestController
@RequestMapping("api/math/suma")
public class SumaController {
  private final Operador service;

  public SumaController(@Qualifier("suma") Operador service) {
    super();
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<BigDecimal> suma(@RequestParam() Long primero, @RequestParam() Long segundo) {
    return ResponseEntity
        .ok(service.operar(new OperandoNumerico(primero), new OperandoNumerico(segundo)));
  }
}
