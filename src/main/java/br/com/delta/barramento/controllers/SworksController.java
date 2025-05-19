package br.com.delta.barramento.controllers;

import br.com.delta.barramento.entities.Cliente;
import br.com.delta.barramento.services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sworks")
public class SworksController {

    private final ClienteService clienteService;

    public SworksController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public Cliente testeConsultaCliente(){
        return clienteService.buscarCliente();
    }



}
