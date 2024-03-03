package com.neoris.proy.security.exception;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

import static com.neoris.proy.utilities.Constantes.SESSION_EXCEPTION_MESSAGE;
import static com.neoris.proy.utilities.HandlerMessage.formatMessageException;

public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint, Serializable {

  private static final long serialVersionUID = -9206078375353792395L;

  public AuthenticationEntryPointHandler() {}

  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException)
      throws IOException {
    formatMessageException(response, HttpServletResponse.SC_BAD_REQUEST, SESSION_EXCEPTION_MESSAGE);
  }
}
