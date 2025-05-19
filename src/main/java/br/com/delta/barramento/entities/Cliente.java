package br.com.delta.barramento.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_name")
    private String name;
    @Column(name = "mother_name")
    private String motherName;
    private String identity;
    @Column(name = "birth_date")
    private String birthDate;
    @Column(name = "gender_id")
    private Integer genderId;
    @Column(name = "marital_status_id")
    private Integer maritalStatusId;
    @Column(name = "person_type_id")
    private Integer personTypeId;
    @Column(name = "government_login")
    private String governmentLogin;
    @Column(name = "government_password")
    private String governmentPassword;
    @Column(name = "partner")
    private String partner;
    @Column(name = "current_score")
    private Integer currentScore;
    @Column(name = "main_phone")
    private String mainPhone;
    @Column(name = "bank_data_id")
    private Integer bankDataId;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "deleted_at")
    private Timestamp deletedAt;
    private String slug;
    @Column(name = "social_name")
    private String socialName;
    @Column(name = "identity_type_id")
    private Integer identityTypeId;
    @Column(name = "main_email")
    private String mainEmail;
    @Column(name = "status_id")
    private Integer statusId;
    @Column(name = "main_address_id")
    private Integer mainAddressId;




}
