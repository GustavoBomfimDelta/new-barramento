package br.com.delta.barramento.controllers;

import br.com.delta.barramento.client.sworks.dtos.CriarProcessoResponseDTO;
import br.com.delta.barramento.client.sworks.dtos.EstimularProcessoRequestDTO;
import br.com.delta.barramento.client.sworks.dtos.ProcessoDTO;
import br.com.delta.barramento.dtos.ProcessoRequestDTO;
import br.com.delta.barramento.entities.Cliente;
import br.com.delta.barramento.services.ClienteService;
import br.com.delta.barramento.services.SworksService;
import br.com.delta.barramento.services.SworksTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sworks")
public class SworksController {

    private final ClienteService clienteService;
    private final SworksService sworksService;
    private final SworksTokenService sworksTokenService;

    public SworksController(ClienteService clienteService, SworksService sworksService, SworksTokenService sworksTokenService) {
        this.clienteService = clienteService;
        this.sworksService = sworksService;
        this.sworksTokenService = sworksTokenService;
    }

    @GetMapping
    public Cliente testeConsultaCliente() {
        return clienteService.buscarCliente();
    }

    @GetMapping("/token")
    public ResponseEntity<String> getToken() {
        String token = sworksTokenService.getToken();
        return ResponseEntity.ok(token);
    }

    @GetMapping("/obterDetalhesProcessamento/{id}")
    public ResponseEntity<ProcessoDTO> obterDetalhesProcessamento(@PathVariable String id) {
        ProcessoDTO processamentoDetalhesResponseDTO = sworksService.obterDetalhesProcessamento(id);
        return ResponseEntity.ok(processamentoDetalhesResponseDTO);
    }

    @PostMapping("/criarProcesso")
    public ResponseEntity<CriarProcessoResponseDTO> criarProcesso(@RequestBody ProcessoRequestDTO processoDTO) {
        CriarProcessoResponseDTO processoResponseDTO = sworksService.criarProcesso(processoDTO);
        return ResponseEntity.ok(processoResponseDTO);
    }

    @PostMapping("/estimularProcesso")
    public ResponseEntity<Void> estimularProcesso(@RequestBody EstimularProcessoRequestDTO processoRequestDTO) {
        sworksService.estimularProcesso(processoRequestDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/iniciarProcesso")
    public ResponseEntity<Void> iniciarProcesso(@RequestParam String identificador) {
        sworksService.iniciarProcesso(identificador);
        return ResponseEntity.ok().build();
    }


}
