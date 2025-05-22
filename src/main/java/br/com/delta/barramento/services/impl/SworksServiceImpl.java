package br.com.delta.barramento.services.impl;

import br.com.delta.barramento.client.sworks.SworksClient;
import br.com.delta.barramento.client.sworks.dtos.CriarProcessoRequestDTO;
import br.com.delta.barramento.client.sworks.dtos.CriarProcessoResponseDTO;
import br.com.delta.barramento.client.sworks.dtos.EstimularProcessoRequestDTO;
import br.com.delta.barramento.client.sworks.dtos.ProcessoDTO;
import br.com.delta.barramento.dtos.ProcessoRequestDTO;
import br.com.delta.barramento.services.SworksService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SworksServiceImpl implements SworksService {
    @Value("${USERNAME_SWORKS}")
    private String usernameSworks;

    @Value("${PASSWORD_SWORKS}")
    private String passwordSworks;

    private final SworksClient sworksClient;
    private final SworksTokenServiceImpl sworksTokenService;

    public SworksServiceImpl(SworksClient sworksClient, SworksTokenServiceImpl sworksTokenServiceImpl) {
        this.sworksClient = sworksClient;
        this.sworksTokenService = sworksTokenServiceImpl;
    }

    @Override
    public String authenticate() {
        return sworksTokenService.getToken();
    }

    @Override
    public ProcessoDTO obterDetalhesProcessamento(String id, String tokenSworks) {
        String sworksToken = sworksTokenService.getToken();
        return sworksClient.getDetailsProccess(id, sworksToken);
    }

    @Override
    public CriarProcessoResponseDTO criarProcesso(ProcessoRequestDTO processoDTO, String tokenSworks) {
        CriarProcessoRequestDTO dto = new CriarProcessoRequestDTO(processoDTO);
        return sworksClient.criarProcesso(dto, "Bearer " + tokenSworks);
    }

    @Override
    public void estimularProcesso(EstimularProcessoRequestDTO estimularProcessoRequestDTO, String tokenSworks) {
        sworksClient.estimularProcesso(estimularProcessoRequestDTO.identificador(), estimularProcessoRequestDTO.estimulo(), "Bearer " + tokenSworks);
    }

    @Override
    public void iniciarProcesso(String identificador, String tokenSworks){
        sworksClient.iniciarProcesso(identificador, "Bearer " + tokenSworks);
    }



}
