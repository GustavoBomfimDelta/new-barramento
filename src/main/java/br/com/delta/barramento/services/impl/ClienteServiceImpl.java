package br.com.delta.barramento.services.impl;

import br.com.delta.barramento.entities.Cliente;
import br.com.delta.barramento.repositories.ClienteRepository;
import br.com.delta.barramento.services.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente buscarCliente() {
        List<Cliente> cliente = clienteRepository.findAll();
        System.out.println(cliente.getFirst());
        return cliente.getFirst();
    }
}
