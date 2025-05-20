package br.com.delta.barramento.client.sworks.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;

@Getter
public class AuthResponse {
    @JsonAlias(value = "access_token")
    private String token;
    @JsonAlias(value = "token_type")
    private String tokenType;
    @JsonAlias(value = "expires_in")
    private Integer expiresIn;
    @JsonAlias(value = ".issued")
    private String issued;
    @JsonAlias(value = ".expires")
    private String expires;


}
