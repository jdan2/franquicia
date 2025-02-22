package com.pragma.franquicias.infrastructure.configuration;

import com.pragma.franquicias.domain.api.IFranquiciaServicePort;
import com.pragma.franquicias.domain.api.IProductoServicePort;
import com.pragma.franquicias.domain.api.ISucursalServicePort;
import com.pragma.franquicias.domain.spi.IFranquiciaPersistencePort;
import com.pragma.franquicias.domain.spi.IProductoPersistencePort;
import com.pragma.franquicias.domain.spi.ISucursalPersistencePort;
import com.pragma.franquicias.domain.usecase.FranquiciaUseCase;
import com.pragma.franquicias.domain.usecase.ProductoUseCase;
import com.pragma.franquicias.domain.usecase.SucursalUseCase;
import com.pragma.franquicias.infrastructure.out.jpa.adapter.FranquiciaAdapter;
import com.pragma.franquicias.infrastructure.out.jpa.adapter.ProductoAdapter;
import com.pragma.franquicias.infrastructure.out.jpa.adapter.SucursalAdapter;
import com.pragma.franquicias.infrastructure.out.jpa.mapper.IFranquiciaEntityMapper;
import com.pragma.franquicias.infrastructure.out.jpa.mapper.IProductoEntityMapper;
import com.pragma.franquicias.infrastructure.out.jpa.mapper.ISucursalEntityMapper;
import com.pragma.franquicias.infrastructure.out.jpa.repository.IFranquiciaRepository;
import com.pragma.franquicias.infrastructure.out.jpa.repository.IProductoRepository;
import com.pragma.franquicias.infrastructure.out.jpa.repository.ISucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IFranquiciaRepository franquiciaRepository;
    private final IFranquiciaEntityMapper franquiciaEntityMapper;
    private final ISucursalRepository sucursalRepository;
    private final ISucursalEntityMapper sucursalEntityMapper;
    private final IProductoRepository productoRepository;
    private final IProductoEntityMapper productoEntityMapper;

    @Bean
    public IFranquiciaPersistencePort franquiciaPersistencePort() {
        return new FranquiciaAdapter(franquiciaRepository, franquiciaEntityMapper);
    }

    @Bean
    public IFranquiciaServicePort franquiciaServicePort() {
        return new FranquiciaUseCase(franquiciaPersistencePort());
    }

    @Bean
    public ISucursalPersistencePort sucursalPersistencePort() {
        return new SucursalAdapter(sucursalRepository, sucursalEntityMapper);
    }

    @Bean
    public ISucursalServicePort sucursalServicePort() {
        return new SucursalUseCase(sucursalPersistencePort());
    }

    @Bean
    public IProductoPersistencePort productoPersistencePort() {
        return new ProductoAdapter(productoRepository, productoEntityMapper);
    }

    @Bean
    public IProductoServicePort productoServicePort() {
        return new ProductoUseCase(productoPersistencePort(), sucursalPersistencePort());
    }
}