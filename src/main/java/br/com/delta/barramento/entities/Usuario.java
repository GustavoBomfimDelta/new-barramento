package br.com.delta.barramento.entities;

import br.com.delta.barramento.dtos.CadastrarUsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String slug;
    private String cpf;
    @Column(name = "name_user")
    private String nome;
    @Column(name = "is_logged_in")
    private Boolean isLoggedIn;
    private String picture;
    @Column(name = "is_first_login")
    private Boolean isFirstLogin;
    @Column(name = "status_id")
    private Integer statusId;
    private String phone;
    @Column(name = "expiration_password")
    private Timestamp expirationPassword;
    @Getter
    @Column(name = "current_password")
    private String currentPassword;
    @Column(name = "old_password")
    private String oldPassword;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "manager_id")
    private Integer managerId;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


    public Usuario(CadastrarUsuarioRequestDTO dto, String senhaCriptografada) {
        this.slug = dto.slug();
        this.cpf = dto.cpf();
        this.nome = dto.nome();
        this.picture = dto.picture();
        this.statusId = dto.statusId();
        this.phone = dto.phone();
        this.currentPassword = senhaCriptografada;
        this.email = dto.email();
        this.role = new Role(dto.role());
        this.companyId = dto.companyId();
        this.managerId = dto.managerId();

        //TODO apagar todas as linhas abaixo
        this.updatedAt = LocalDateTime.now();
        this.expirationPassword = Timestamp.valueOf(LocalDateTime.now().plusDays(50));

    }


}
