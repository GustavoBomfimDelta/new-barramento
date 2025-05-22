package br.com.delta.barramento.services;

public interface SworksTokenService {
    String getToken();

    void evictTokenCache();
}
