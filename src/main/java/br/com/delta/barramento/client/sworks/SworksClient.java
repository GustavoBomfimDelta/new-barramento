package br.com.delta.barramento.client.sworks;

import br.com.delta.barramento.client.sworks.dtos.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

@FeignClient(name = "SworksClient", url = "${URL_SWORKS}")
public interface SworksClient {

    @PostMapping(value = "/token", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    AuthResponse getToken(
            @RequestPart("username") String username,
            @RequestPart("password") String password
    );

}
