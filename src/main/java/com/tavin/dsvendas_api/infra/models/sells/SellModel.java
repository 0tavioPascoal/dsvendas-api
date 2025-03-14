package com.tavin.dsvendas_api.infra.models.sells;


import com.tavin.dsvendas_api.infra.models.ClientModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "tb_sell")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class SellModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private ClientModel client;

    @Enumerated(EnumType.STRING)
    private PaymentEnum payment;

    @OneToMany(mappedBy = "sellModel")
    private List<ItensSell> itens;

    @Column
    private BigDecimal total;

    @Column
    @CreatedDate
    private LocalDate created;

}
