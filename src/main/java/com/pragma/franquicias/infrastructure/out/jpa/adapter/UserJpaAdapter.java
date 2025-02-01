package com.pragma.franquicias.infrastructure.out.jpa.adapter;

import com.pragma.franquicias.domain.model.UserModel;
import com.pragma.franquicias.domain.spi.IUserPersistencePort;
import com.pragma.franquicias.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.franquicias.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.franquicias.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;


    @Override
    public UserModel saveUser(UserModel userModel) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(userModel));
            return userEntityMapper.toOwnerModel(userEntity);
    }

    @Override
    public UserModel getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElse(null);
        return userEntityMapper.toOwnerModel(userEntity);
    }

    @Override
    public UserModel findByEmail(String email) {
        return userEntityMapper.toOwnerModel(
                userRepository.findByEmail(email)
                        .orElse(null));
    }

    @Override
    public UserModel findByDocumentId(String document) {
        UserEntity userEntity = userRepository.findByDocumentId(document).orElse(null);
        return userEntityMapper.toOwnerModel(userEntity);
    }

}