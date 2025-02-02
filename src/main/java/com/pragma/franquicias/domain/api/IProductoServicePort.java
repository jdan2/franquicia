package com.pragma.franquicias.domain.api;

import com.pragma.franquicias.domain.model.ProductoModelo;
import com.pragma.franquicias.domain.model.SucursalModelo;
import reactor.core.publisher.Mono;

public interface IProductoServicePort {

    Mono<ProductoModelo>  agregarProducto(ProductoModelo productoModelo);
    Mono<ProductoModelo>  actualizarProducto(ProductoModelo productoModelo);
    Mono<Void>  eliminarProducto(Long productoId);

}