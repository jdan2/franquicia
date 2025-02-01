package com.pragma.franquicias.domain.api;

import com.pragma.franquicias.domain.model.UserModel;

public interface IUserServicePort {

    UserModel getUser(Long id);

}