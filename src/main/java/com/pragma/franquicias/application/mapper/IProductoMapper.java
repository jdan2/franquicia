package com.pragma.franquicias.application.mapper;

import com.pragma.franquicias.application.dto.request.ProductoRequestDto;
import com.pragma.franquicias.application.dto.request.StockRequestDto;
import com.pragma.franquicias.application.dto.response.ProductoMaxStockResponseDto;
import com.pragma.franquicias.application.dto.response.ProductoResponseDto;
import com.pragma.franquicias.domain.model.ProductoMaxStockModelo;
import com.pragma.franquicias.domain.model.ProductoModelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProductoMapper {


    ProductoModelo toModel (Long sucursalId, ProductoRequestDto productoRequestDto);
    ProductoResponseDto toResponse(ProductoModelo productoModelo);
    @Mapping(source = "productoId", target = "id")
    ProductoModelo toModelStock(Long productoId, StockRequestDto stockRequestDto);
    ProductoMaxStockResponseDto toModelMaxStock(ProductoMaxStockModelo productoMaxStockModelo);


}
