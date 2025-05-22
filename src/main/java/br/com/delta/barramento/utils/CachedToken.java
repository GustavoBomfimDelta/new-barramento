package br.com.delta.barramento.utils;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class CachedToken {
    @Getter
    private final String token;
    private final LocalDateTime expiresAt;

    public CachedToken(String token, LocalDateTime expiresAt) {
        this.token = token;
        this.expiresAt = expiresAt;
    }

    public boolean isExpired() {
        return LocalDateTime.now(ZoneOffset.UTC).isAfter(expiresAt);
    }
}
