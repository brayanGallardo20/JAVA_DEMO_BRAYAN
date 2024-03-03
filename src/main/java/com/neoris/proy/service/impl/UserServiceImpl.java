package com.neoris.proy.service.impl;

import com.neoris.proy.model.User;
import com.neoris.proy.repository.IUserRepository;
import com.neoris.proy.request.UserRequest;
import com.neoris.proy.response.UserResponse;
import com.neoris.proy.security.JwtTokenProvider;
import com.neoris.proy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.neoris.proy.utilities.Constantes.ROL_ADMIN;
import static com.neoris.proy.utilities.Constantes.ROL_USER;
import static com.neoris.proy.utilities.Date.dateNow;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private IUserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse create(UserRequest request) {

        final UserRequest encryptDoSignInRequest =
                new UserRequest(
                        request.getName(),
                        request.getEmail(),
                        passwordEncoder.encode(request.getPassword()),
                        request.getPhones());

        User user = repository.findByEmail(request.getEmail());

        final List<String> listRoles = new ArrayList<>();
        listRoles.add(ROL_ADMIN);
        listRoles.add(ROL_USER);

        final String token = jwtTokenProvider.createToken(request.getEmail(), listRoles);

        if (user == null) {
            user = repository.save(
                            new User(
                                    request.getName(),
                                    request.getEmail(),
                                    encryptDoSignInRequest.getPassword(),
                                    dateNow(),
                                    dateNow(),
                                    dateNow(),
                                    token,
                                    listRoles,
                                    true));
        }

        if (user.getToken() != null) {

            final Authentication doAuthentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    user.getEmail(), request.getPassword()));

            final String dateNow = dateNow();
            final int updateUser =
                    repository.updateUser(user.getEmail(), token, dateNow, dateNow);
        }

        return  new UserResponse(
                        user.getId(),
                        user.getCreated(),
                        user.getModified(),
                        user.getLastLogin(),
                        user.getToken(),
                        user.isActive());

    }
}
