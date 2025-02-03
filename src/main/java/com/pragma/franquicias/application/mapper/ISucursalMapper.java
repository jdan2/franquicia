package com.pragma.franquicias.application.mapper;

import com.pragma.franquicias.application.dto.request.SucursalNombreRequestDto;
import com.pragma.franquicias.application.dto.request.SucursalRequestDto;
import com.pragma.franquicias.application.dto.response.SucursalResponseDto;
import com.pragma.franquicias.domain.model.SucursalModelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISucursalMapper {


    SucursalModelo toModel (Long franquiciaId, SucursalRequestDto sucursalRequestDto);
    SucursalResponseDto toResponse(SucursalModelo sucursalModelo);
    @Mapping(source = "sucursalId", target = "id")
    SucursalModelo toModelNombre(Long sucursalId, SucursalNombreRequestDto sucursalNombreRequestDto);
}
