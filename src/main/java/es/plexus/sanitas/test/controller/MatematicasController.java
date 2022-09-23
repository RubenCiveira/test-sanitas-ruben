package es.plexus.sanitas.test.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.plexus.sanitas.test.service.math.Operador;
import es.plexus.sanitas.test.service.math.OperandoNumerico;
import es.plexus.sanitas.test.service.math.TipoOperador;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/math")
public class MatematicasController {
  private final List<Operador> operadores;

  @Operation(summary = "substract ", description = "subtraction of numbers",
      tags = {"calculadora-controller"})
  @GetMapping
  public ResponseEntity<BigDecimal> resta(
      @Parameter(in = ParameterIn.QUERY, description = "Operacion", required = true,
          schema = @Schema()) @RequestParam() TipoOperador operador,
      @Parameter(in = ParameterIn.QUERY, description = "Primero operador", required = true,
          schema = @Schema()) @RequestParam() Long primero,
      @Parameter(in = ParameterIn.QUERY, description = "Segundo operador", required = true,
          schema = @Schema()) @RequestParam() Long segundo) {
    return operadores.stream().filter(op -> op.acepta(operador)).findFirst()
        .map(op -> op.operar(new OperandoNumerico(primero), new OperandoNumerico(segundo)))
        .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
