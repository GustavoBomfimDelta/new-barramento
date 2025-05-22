package br.com.delta.barramento.dtos;

public record ProcessoRequestDTO(
        Integer codigoWorkFlow,
        String nome,
        String cpf,
        String dataNascimento,
        String email,
        String telefone

) {
}
