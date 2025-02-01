package com.pragma.franquicias.application.handler.impl;

import com.pragma.franquicias.application.dto.response.UserResponseDto;
import com.pragma.franquicias.application.handler.IUserHandler;
import com.pragma.franquicias.application.mapper.IUserResponseMapper;
import com.pragma.franquicias.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserResponseMapper userResponseMapper;
    

    @Override
    public UserResponseDto getUser(Long userId) {
        return userResponseMapper.toUserResponse(userServicePort.getUser(userId)) ;
    }

}