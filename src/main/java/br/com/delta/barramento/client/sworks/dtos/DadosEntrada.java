package br.com.delta.barramento.client.sworks.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DadosEntrada {
    @JsonProperty(value = "Nome")
    private String nome;
    @JsonProperty(value = "Valor")
    private String valor;

}
