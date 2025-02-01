package com.pragma.franquicias.domain.spi;

import com.pragma.franquicias.domain.model.UserModel;

public interface IUserPersistencePort {
    UserModel saveUser(UserModel userModel);
    UserModel getUserById(Long userId);
    UserModel findByEmail(String email);
    UserModel findByDocumentId(String document);
}