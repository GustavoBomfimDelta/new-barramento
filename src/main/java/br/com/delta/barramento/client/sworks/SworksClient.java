package br.com.delta.barramento.client.sworks;

import br.com.delta.barramento.client.sworks.dtos.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "SworksClient", url = "${URL_SWORKS}")
public interface SworksClient {

    @PostMapping(value = "/token", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    AuthResponse getToken(
            @RequestPart("username") String username,
            @RequestPart("password") String password
    );

    @GetMapping(value = "/api/v1/Processo/{idProccess}")
    ProcessoDTO getDetailsProccess(@PathVariable String idProccess, @RequestHeader("Authorization") String authorization);

    @PostMapping(value = "/api/v1/Processo")
    CriarProcessoResponseDTO criarProcesso(@RequestBody CriarProcessoRequestDTO processoRequestDTO, @RequestHeader ("Authorization") String authorization);

    @PostMapping(value = "/api/v1/Processo/EstimularProcesso")
    void estimularProcesso(@RequestParam String identificador, @RequestParam Integer estimulo, @RequestHeader ("Authorization") String authorization);
}
