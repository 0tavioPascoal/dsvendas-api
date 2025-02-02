package com.tavin.dsvendas_api.infra.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_sell")
public class SellModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private ClientModel client;

    


}
