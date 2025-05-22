package br.com.delta.barramento.services;

import br.com.delta.barramento.client.sworks.dtos.AutenticarUsuarioRequestDTO;

public interface UsuarioService {
    String autenticarUsuario(AutenticarUsuarioRequestDTO dto);
}
