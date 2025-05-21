package br.com.delta.barramento.services;

import br.com.delta.barramento.client.sworks.dtos.AuthResponse;
import br.com.delta.barramento.client.sworks.dtos.ProcessoDTO;

public interface SworksService {
    AuthResponse authenticate();

    ProcessoDTO obterDetalhesProcessamento(String id, String tokenSworks);

}
