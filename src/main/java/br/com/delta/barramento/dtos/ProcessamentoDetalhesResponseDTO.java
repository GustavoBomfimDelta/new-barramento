package br.com.delta.barramento.dtos;

import java.util.List;

public class ProcessamentoDetalhesResponseDTO {

    private Integer codigo;
    private String codigoLegado;
    private String identificador;
    private String dataCriacao;
    private String disponivelProcessamento;
    private String inicioProcessamento;
    private String fimProcessamento;
    private String proximoProcessamento;
    private Integer status;
    private String motivoReprovacao;
    private String observacoes;
    private DadosEntradaResponseDTO dadosEntrada;
    private List<Object> objetos;
    private List<Object> documentos;
    private List<Object> pendenciasDocumentos;

}
