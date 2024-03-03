package com.neoris.proy.security;

import com.neoris.proy.model.User;
import com.neoris.proy.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

  private IUserRepository users;

  public CustomUserDetailsService(IUserRepository users) {
    this.users = users;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    CustomUserDetails customUserDetails = null;

    User user = users.findByEmail(username);
    if (user != null) {
      customUserDetails =
          new CustomUserDetails(user.getEmail(), user.getPassword(), user.getRoles());
    }

    return customUserDetails;
  }
}
