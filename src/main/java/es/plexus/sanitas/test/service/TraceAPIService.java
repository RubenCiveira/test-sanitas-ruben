package es.plexus.sanitas.test.service;

import org.springframework.stereotype.Service;
import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

@Service
public class TraceAPIService implements TracerAPI {
  private final TracerImpl trace = new TracerImpl();

  @Override
  public <T> void trace(T arg0) {
    trace.trace(arg0);
  }
}
