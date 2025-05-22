package br.com.delta.barramento.services.impl;

import br.com.delta.barramento.client.sworks.SworksClient;
import br.com.delta.barramento.client.sworks.dtos.CriarProcessoRequestDTO;
import br.com.delta.barramento.client.sworks.dtos.CriarProcessoResponseDTO;
import br.com.delta.barramento.client.sworks.dtos.EstimularProcessoRequestDTO;
import br.com.delta.barramento.client.sworks.dtos.ProcessoDTO;
import br.com.delta.barramento.dtos.ProcessoRequestDTO;
import br.com.delta.barramento.services.SworksService;
import org.springframework.stereotype.Service;

@Service
public class SworksServiceImpl implements SworksService {


    private final SworksClient sworksClient;
    private final SworksTokenServiceImpl sworksTokenService;

    public SworksServiceImpl(SworksClient sworksClient, SworksTokenServiceImpl sworksTokenServiceImpl) {
        this.sworksClient = sworksClient;
        this.sworksTokenService = sworksTokenServiceImpl;
    }

    @Override
    public ProcessoDTO obterDetalhesProcessamento(String id) {
        return sworksClient.getDetailsProccess(id, getTokenSworks());
    }

    @Override
    public CriarProcessoResponseDTO criarProcesso(ProcessoRequestDTO processoDTO) {
        CriarProcessoRequestDTO dto = new CriarProcessoRequestDTO(processoDTO);
        return sworksClient.criarProcesso(dto, getTokenSworks());
    }

    @Override
    public void estimularProcesso(EstimularProcessoRequestDTO estimularProcessoRequestDTO) {
        sworksClient.estimularProcesso(estimularProcessoRequestDTO.identificador(), estimularProcessoRequestDTO.estimulo(), getTokenSworks());
    }

    @Override
    public void iniciarProcesso(String identificador){
        sworksClient.iniciarProcesso(identificador, getTokenSworks());
    }

    private String getTokenSworks() {
        return sworksTokenService.getToken();
    }



}
