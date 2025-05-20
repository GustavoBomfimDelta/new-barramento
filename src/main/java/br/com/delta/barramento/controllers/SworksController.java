package br.com.delta.barramento.controllers;

import br.com.delta.barramento.client.sworks.dtos.AuthResponse;
import br.com.delta.barramento.entities.Cliente;
import br.com.delta.barramento.services.ClienteService;
import br.com.delta.barramento.services.SworksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public AuthResponse getToken(){
       return sworksService.authenticate();
    }



}
