package br.com.delta.barramento.controllers;

import br.com.delta.barramento.client.sworks.dtos.AuthResponse;
import br.com.delta.barramento.client.sworks.dtos.CriarProcessoResponseDTO;
import br.com.delta.barramento.client.sworks.dtos.EstimularProcessoRequestDTO;
import br.com.delta.barramento.client.sworks.dtos.ProcessoDTO;
import br.com.delta.barramento.dtos.ProcessoRequestDTO;
import br.com.delta.barramento.entities.Cliente;
import br.com.delta.barramento.services.ClienteService;
import br.com.delta.barramento.services.SworksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sworks")
public class SworksController {

    private final ClienteService clienteService;
    private final SworksService sworksService;

    public SworksController(ClienteService clienteService, SworksService sworksService) {
        this.clienteService = clienteService;
        this.sworksService = sworksService;
    }

    @GetMapping
    public Cliente testeConsultaCliente(){
        return clienteService.buscarCliente();
    }

    @GetMapping("/token")
    public ResponseEntity<AuthResponse> getToken(){
        AuthResponse authResponse = sworksService.authenticate();
        return ResponseEntity.ok(authResponse);
    }

    @GetMapping("/obterDetalhesProcessamento/{id}")
    public ResponseEntity<ProcessoDTO> obterDetalhesProcessamento(@PathVariable String id, @RequestParam String tokenSworks){
        ProcessoDTO processamentoDetalhesResponseDTO = sworksService.obterDetalhesProcessamento(id, tokenSworks);
        return ResponseEntity.ok(processamentoDetalhesResponseDTO);
    }

    @PostMapping("/criarProcesso")
    public ResponseEntity<CriarProcessoResponseDTO> criarProcesso (@RequestBody ProcessoRequestDTO processoDTO){
        CriarProcessoResponseDTO processoResponseDTO = sworksService.criarProcesso(processoDTO, processoDTO.token());
        return ResponseEntity.ok(processoResponseDTO);
    }

    @PostMapping("/estimularProcesso/{tokenSworks}")
    public ResponseEntity<Void> estimularProcesso(@RequestBody EstimularProcessoRequestDTO processoRequestDTO, @PathVariable String tokenSworks){
        sworksService.estimularProcesso(processoRequestDTO, tokenSworks);
        return ResponseEntity.ok().build();
    }




}
