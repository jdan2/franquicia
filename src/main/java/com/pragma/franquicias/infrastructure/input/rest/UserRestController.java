package com.pragma.franquicias.infrastructure.input.rest;


import com.pragma.franquicias.application.dto.response.UserResponseDto;
import com.pragma.franquicias.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler objectHandler;

    @Operation(summary = "Buscar Usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario no se encuentra", content = @Content)
    })
    @GetMapping("/get-user")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<UserResponseDto> getUser(@RequestParam(required = true) Long userId) {
        return ResponseEntity.ok(objectHandler.getUser(userId));
    }


}