package com.pragma.franquicias.application.mapper;

import com.pragma.franquicias.application.dto.response.UserResponseDto;
import com.pragma.franquicias.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {


    UserResponseDto toUserResponse(UserModel userModel);
}
