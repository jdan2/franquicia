package com.pragma.franquicias.infrastructure.configuration;

import com.pragma.franquicias.domain.api.IUserServicePort;
import com.pragma.franquicias.domain.spi.IUserPersistencePort;
import com.pragma.franquicias.domain.usecase.UserUseCase;
import com.pragma.franquicias.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.pragma.franquicias.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.franquicias.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final IUserEntityMapper objectEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, objectEntityMapper);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }




}