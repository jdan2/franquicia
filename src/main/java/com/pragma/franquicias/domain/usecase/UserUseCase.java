package com.pragma.franquicias.domain.usecase;

import com.pragma.franquicias.domain.api.IUserServicePort;
import com.pragma.franquicias.domain.exception.DomainException;
import com.pragma.franquicias.domain.model.UserModel;
import com.pragma.franquicias.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {

    public static final String USER_NO_FOUND = "No se encontro propietario";
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public UserModel getUser(Long id) {
        UserModel userModel = userPersistencePort.getUserById(id);
        if (userModel == null) {
            throw new DomainException(USER_NO_FOUND);
        }
        return userModel;
    }


}