package br.com.delta.barramento.services;

import br.com.delta.barramento.client.sworks.dtos.AuthResponse;
import br.com.delta.barramento.client.sworks.dtos.CriarProcessoResponseDTO;
import br.com.delta.barramento.client.sworks.dtos.ProcessoDTO;
import br.com.delta.barramento.dtos.ProcessoRequestDTO;

public interface SworksService {
    AuthResponse authenticate();

    ProcessoDTO obterDetalhesProcessamento(String id, String tokenSworks);

    CriarProcessoResponseDTO criarProcesso(ProcessoRequestDTO processoDTO, String tokenSworks);
}
