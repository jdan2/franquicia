package com.pragma.franquicias.application.handler;

import com.pragma.franquicias.application.dto.response.UserResponseDto;

public interface IUserHandler {


    UserResponseDto getUser(Long userId);



}