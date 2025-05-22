package br.com.delta.barramento.services.impl;

import br.com.delta.barramento.client.sworks.SworksClient;
import br.com.delta.barramento.client.sworks.dtos.AuthResponse;
import br.com.delta.barramento.services.SworksTokenService;
import br.com.delta.barramento.utils.CachedToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SworksTokenServiceImpl implements SworksTokenService {

    @Value("${USERNAME_SWORKS}")
    private String usernameSworks;

    @Value("${PASSWORD_SWORKS}")
    private String passwordSworks;

    private final SworksClient sworksClient;
    private CachedToken cachedToken;

    public SworksTokenServiceImpl(SworksClient sworksClient) {
        this.sworksClient = sworksClient;
    }


    @Override
    public synchronized String getToken() {
        if (cachedToken == null || cachedToken.isExpired()) {
            AuthResponse authResponse = sworksClient.getToken(usernameSworks, passwordSworks);
            LocalDateTime expiresAt = parseExpires(authResponse.getExpires());
            String fullToken = authResponse.getTokenType() + " " + authResponse.getToken();
            cachedToken = new CachedToken(fullToken, expiresAt);
        }
        return cachedToken.getToken();
    }

    private LocalDateTime parseExpires(String expires) {
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
        return ZonedDateTime.parse(expires, formatter).withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public void evictTokenCache() {
        cachedToken = null;
    }

}
