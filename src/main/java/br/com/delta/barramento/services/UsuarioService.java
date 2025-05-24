package br.com.delta.barramento.services;

import br.com.delta.barramento.client.sworks.dtos.AutenticarUsuarioRequestDTO;
import br.com.delta.barramento.dtos.CadastrarUsuarioRequestDTO;

public interface UsuarioService {
    String autenticarUsuario(AutenticarUsuarioRequestDTO dto);

    void criarUsuario(CadastrarUsuarioRequestDTO dto);
}
