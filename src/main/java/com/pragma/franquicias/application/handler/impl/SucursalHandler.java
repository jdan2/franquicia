package com.pragma.franquicias.application.handler.impl;

import com.pragma.franquicias.application.dto.request.SucursalNombreRequestDto;
import com.pragma.franquicias.application.dto.request.SucursalRequestDto;
import com.pragma.franquicias.application.dto.response.SucursalResponseDto;
import com.pragma.franquicias.application.handler.ISucursalHandler;
import com.pragma.franquicias.application.mapper.ISucursalMapper;
import com.pragma.franquicias.domain.api.ISucursalServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class SucursalHandler implements ISucursalHandler {

    private final ISucursalServicePort sucursalServicePort;
    private final ISucursalMapper sucursalMapper;

    @Override
    public Mono<SucursalResponseDto> agregarSucursal(Long franquiciaId, SucursalRequestDto sucursalRequestDto) {
        return Mono.just(sucursalMapper.toModel(franquiciaId, sucursalRequestDto))
                .flatMap(sucursalServicePort::agregarSucursal)
                .map(sucursalMapper::toResponse);
    }

    @Override
    public Mono<SucursalResponseDto> agregarSucursal(Long sucursalId, SucursalNombreRequestDto sucursalNombreRequestDto) {
        return Mono.just(sucursalMapper.toModelNombre(sucursalId, sucursalNombreRequestDto))
                .flatMap(sucursalServicePort::actualizarFranquicia)
                .map(sucursalMapper::toResponse);
    }
}