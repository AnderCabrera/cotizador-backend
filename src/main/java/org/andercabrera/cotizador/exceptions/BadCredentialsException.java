package org.andercabrera.cotizador.exceptions;

public class BadCredentialsException extends RuntimeException {
  public BadCredentialsException(String message) {
    super(message);
  }
}
