package br.com.delta.barramento.client.sworks.dtos;

public record EstimularProcessoRequestDTO(
        String identificador,
        Integer estimulo,
        String mensagem
) {
}
