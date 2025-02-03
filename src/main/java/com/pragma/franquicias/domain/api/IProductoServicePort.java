package com.pragma.franquicias.domain.api;

import com.pragma.franquicias.domain.model.ProductoMaxStockModelo;
import com.pragma.franquicias.domain.model.ProductoModelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductoServicePort {

    Mono<ProductoModelo>  agregarProducto(ProductoModelo productoModelo);
    Mono<ProductoModelo>  actualizarProducto(ProductoModelo productoModelo);
    Mono<ProductoModelo>  actualizarNombreProducto(ProductoModelo productoModelo);
    Mono<Void>  eliminarProducto(Long productoId);
    Flux<ProductoMaxStockModelo> obtenerProductoMaxStockPorSucursal(Long franquiciaId);

}