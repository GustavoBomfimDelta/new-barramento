package br.com.delta.barramento.dtos;

import lombok.Getter;

@Getter
public class DadosEntradaResponseDTO {
    private String nome;
    private String cpf;
    private String dtNascimento;
    private String email;
    private String telefone;
    private String identificadorProcesso;
    private String codigoProcesso;
}
