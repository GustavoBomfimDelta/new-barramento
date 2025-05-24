package br.com.delta.barramento.services;

public interface PasswordService {
    String encryptPassword(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);
}
