package br.com.delta.barramento.client.sworks.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CriarProcessoResponseDTO(
        @JsonProperty(value = "Identificador")
        String identificador,
        @JsonProperty(value = "CodigoProcesso")
        Integer codigoProcesso
) {
}
