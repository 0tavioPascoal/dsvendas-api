package com.tavin.dsvendas_api.infra.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_client")
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String cpf;
    private String address;
    private LocalDate birthday;

    @CreatedDate
    private LocalDate created;

    @LastModifiedDate
    private LocalDate modified;
}
