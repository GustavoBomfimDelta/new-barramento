package br.com.delta.barramento.services;

import br.com.delta.barramento.client.sworks.dtos.CriarProcessoResponseDTO;
import br.com.delta.barramento.client.sworks.dtos.EstimularProcessoRequestDTO;
import br.com.delta.barramento.client.sworks.dtos.ProcessoDTO;
import br.com.delta.barramento.dtos.ProcessoRequestDTO;

public interface SworksService {

    ProcessoDTO obterDetalhesProcessamento(String id);

    CriarProcessoResponseDTO criarProcesso(ProcessoRequestDTO processoDTO);

    void estimularProcesso(EstimularProcessoRequestDTO estimularProcessoRequestDTO);

    void iniciarProcesso(String identificador);
}
