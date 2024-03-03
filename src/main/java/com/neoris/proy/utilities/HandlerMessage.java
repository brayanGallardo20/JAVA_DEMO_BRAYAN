package com.neoris.proy.utilities;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.neoris.proy.utilities.Constantes.*;

public class HandlerMessage {

  public HandlerMessage() {}

  public static void formatMessageException(
      final HttpServletResponse response, final int handlerStatus, final String handlerMeessage)
      throws IOException {

    String json = String.format(FORMAT_MESSAGE_JWT, handlerMeessage);
    response.setStatus(handlerStatus);
    response.setContentType(TYPE_MESSAGE_JWT);
    response.setCharacterEncoding(CHARACTER_ENCODING_MESSAGE_JWT);
    response.getWriter().write(json);
  }

}
