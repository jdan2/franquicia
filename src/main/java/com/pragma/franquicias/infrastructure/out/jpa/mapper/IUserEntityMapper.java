package com.pragma.franquicias.infrastructure.out.jpa.mapper;

import com.pragma.franquicias.domain.model.UserModel;
import com.pragma.franquicias.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserEntityMapper {

    UserEntity toEntity(UserModel user);
    UserModel toOwnerModel(UserEntity userEntity);
}