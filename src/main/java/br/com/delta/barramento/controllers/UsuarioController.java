package br.com.delta.barramento.controllers;

import br.com.delta.barramento.client.sworks.dtos.AutenticarUsuarioRequestDTO;
import br.com.delta.barramento.dtos.CadastrarUsuarioRequestDTO;
import br.com.delta.barramento.entities.Usuario;
import br.com.delta.barramento.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/autenticar")
    public ResponseEntity<String> autenticarUsuario(@RequestBody AutenticarUsuarioRequestDTO dto) {
        String token = usuarioService.autenticarUsuario(dto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody CadastrarUsuarioRequestDTO dto) {
        usuarioService.criarUsuario(dto);
        return ResponseEntity.noContent().build();
    }
}
