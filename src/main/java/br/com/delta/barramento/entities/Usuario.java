package br.com.delta.barramento.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;

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
    @Column(name = "is_admin")
    private Boolean isAdmin;
    @Column(name = "isMaster")
    private Boolean isMaster;
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
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "manager_id")
    private Integer managerId;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "deleted_at")
    private Timestamp deletedAt;
    private Boolean special;


}
