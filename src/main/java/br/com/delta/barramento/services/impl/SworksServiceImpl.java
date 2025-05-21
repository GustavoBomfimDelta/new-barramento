package br.com.delta.barramento.services.impl;

import br.com.delta.barramento.client.sworks.SworksClient;
import br.com.delta.barramento.client.sworks.dtos.*;
import br.com.delta.barramento.dtos.ProcessoRequestDTO;
import br.com.delta.barramento.services.SworksService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SworksServiceImpl implements SworksService {
    @Value("${USERNAME_SWORKS}")
    private String usernameSworks;

    @Value("${PASSWORD_SWORKS}")
    private String passwordSworks;

    private final SworksClient sworksClient;

    public SworksServiceImpl(SworksClient sworksClient) {
        this.sworksClient = sworksClient;
    }

    @Override
    public AuthResponse authenticate() {
        return sworksClient.getToken(usernameSworks, passwordSworks);
    }

    @Override
    public ProcessoDTO obterDetalhesProcessamento(String id, String tokenSworks) {
        return sworksClient.getDetailsProccess(id, "Bearer " + tokenSworks);
    }

    @Override
    public CriarProcessoResponseDTO criarProcesso(ProcessoRequestDTO processoDTO, String tokenSworks) {
        CriarProcessoRequestDTO dto = new CriarProcessoRequestDTO(processoDTO);
        return sworksClient.criarProcesso(dto, "Bearer " + tokenSworks);
    }



}
