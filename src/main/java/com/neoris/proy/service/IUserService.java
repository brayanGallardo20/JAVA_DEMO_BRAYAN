package com.neoris.proy.service;

import com.neoris.proy.request.UserRequest;
import com.neoris.proy.response.UserResponse;
import org.springframework.stereotype.Service;

public interface IUserService {

    UserResponse create (UserRequest request);

}
