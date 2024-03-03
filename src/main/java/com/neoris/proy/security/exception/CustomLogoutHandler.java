package com.neoris.proy.security.exception;

import com.neoris.proy.model.User;
import com.neoris.proy.repository.IUserRepository;
import com.neoris.proy.security.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

import static com.neoris.proy.utilities.Constantes.NAME_TOKEN_SESSION;

public class CustomLogoutHandler implements LogoutHandler, Serializable {

  private static final long serialVersionUID = -3409865897460953769L;

  private final transient JwtTokenProvider jwtTokenProvider;
  private final transient IUserRepository globalLogicRepository;

  public CustomLogoutHandler(
      final JwtTokenProvider jwtTokenProvider, IUserRepository globalLogicRepository) {
    this.globalLogicRepository = globalLogicRepository;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public void logout(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    String tokenSearch = request.getHeader(NAME_TOKEN_SESSION);
    final User findEmail = globalLogicRepository.findUserByToken(tokenSearch);
    final String updateToken =
        jwtTokenProvider.revocateToken(
            jwtTokenProvider.getUsername(tokenSearch), findEmail.getRoles());
    globalLogicRepository.revocateToken(tokenSearch, updateToken);
  }
}
