package br.com.delta.barramento.services;

import br.com.delta.barramento.client.sworks.dtos.AuthResponse;

public interface SworksService {
    AuthResponse authenticate();
}
