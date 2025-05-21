package br.com.delta.barramento.client.sworks.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ProcessoDTO {
    @JsonProperty(value = "Codigo")
    private Integer codigo;
    @JsonProperty(value = "codigoLegado")
    private String codigoLegado;
    @JsonProperty(value = "Identificador")
    private String identificador;
    @JsonProperty(value = "DataCriacao")
    private String dataCriacao;
    @JsonProperty(value = "DisponivelProcessamento")
    private String disponivelProcessamento;
    @JsonProperty(value = "InicioProcessamento")
    private String inicioProcessamento;
    @JsonProperty(value = "FimProcessamento")
    private String fimProcessamento;
    @JsonProperty(value = "ProximoProcessamento")
    private String proximoProcessamento;
    @JsonProperty(value = "Status")
    private Integer status;
    @JsonProperty(value = "MotivoReprovacao")
    private String motivoReprovacao;
    @JsonProperty(value = "Observacoes")
    private String observacoes;
    @JsonProperty(value = "DadosEntrada")
    private List<Object> dadosEntrada;
    @JsonProperty(value = "Objetos")
    private List<Object> objetos;
    @JsonProperty(value = "Documentos")
    private List<Object> documentos;
    @JsonProperty(value = "PendenciasDocumentos")
    private List<Object> pendenciasDocumentos;


}
