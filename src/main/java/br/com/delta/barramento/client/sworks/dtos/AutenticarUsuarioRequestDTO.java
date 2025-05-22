package br.com.delta.barramento.client.sworks.dtos;

public record AutenticarUsuarioRequestDTO(
        String email,
        String password
) {
}
