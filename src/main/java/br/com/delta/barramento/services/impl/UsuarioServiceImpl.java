package br.com.delta.barramento.services.impl;

import br.com.delta.barramento.client.sworks.dtos.AutenticarUsuarioRequestDTO;
import br.com.delta.barramento.entities.Usuario;
import br.com.delta.barramento.exceptions.ResourceNotFoundException;
import br.com.delta.barramento.repositories.UsuarioRepository;
import br.com.delta.barramento.services.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public String autenticarUsuario(AutenticarUsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.email()).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        if (dto.password().equals(usuario.getCurrentPassword())) {
            return "preciso retornar um token";
        }
        throw new ResourceNotFoundException("Email ou senha incorretos");
    }
}
