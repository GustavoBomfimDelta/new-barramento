package br.com.delta.barramento.dtos;

public record CadastrarUsuarioRequestDTO(

        String slug,
        String cpf,
        String nome,
        String picture,
        Integer statusId,
        String phone,
        String currentPassword,
        String email,
        Integer role,
        Integer companyId,
        Integer managerId

) {
}
