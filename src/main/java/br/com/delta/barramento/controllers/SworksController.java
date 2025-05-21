package br.com.delta.barramento.controllers;

import br.com.delta.barramento.client.sworks.dtos.AuthResponse;
import br.com.delta.barramento.client.sworks.dtos.ProcessoDTO;
import br.com.delta.barramento.dtos.ProcessamentoDetalhesResponseDTO;
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



}
