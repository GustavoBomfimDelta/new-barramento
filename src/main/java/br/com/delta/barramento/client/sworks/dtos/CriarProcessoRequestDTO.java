package br.com.delta.barramento.client.sworks.dtos;

import br.com.delta.barramento.dtos.ProcessoRequestDTO;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CriarProcessoRequestDTO {
    private Integer codigoWorkflow;
    private List<DadosEntrada> dadosEntrada =  new ArrayList<>();
    private String document;
    private String proccessType;

    public CriarProcessoRequestDTO(ProcessoRequestDTO dto){
        this.codigoWorkflow = dto.codigoWorkFlow();
        this.dadosEntrada.add(new DadosEntrada("nome", dto.nome()));
        this.dadosEntrada.add(new DadosEntrada("cpf", dto.cpf()));
        this.dadosEntrada.add(new DadosEntrada("dtNascimento", dto.dataNascimento()));
        this.dadosEntrada.add(new DadosEntrada("email", dto.email()));
        this.dadosEntrada.add(new DadosEntrada("telefone", dto.telefone()));
        this.document = dto.cpf();
        //this.proccessType = "B";
    }



}
