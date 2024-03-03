package com.neoris.proy.security.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

import static com.neoris.proy.utilities.Constantes.ACCESS_DENIED_EXCEPTION_MESSAGE;
import static com.neoris.proy.utilities.HandlerMessage.formatMessageException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler, Serializable {

  private static final long serialVersionUID = -6859297070553441327L;

  public CustomAccessDeniedHandler() {}

  @Override
  public void handle(
      HttpServletRequest request, HttpServletResponse response, AccessDeniedException arg2)
      throws IOException {
    formatMessageException(
        response, HttpServletResponse.SC_UNAUTHORIZED, ACCESS_DENIED_EXCEPTION_MESSAGE);
  }
}
