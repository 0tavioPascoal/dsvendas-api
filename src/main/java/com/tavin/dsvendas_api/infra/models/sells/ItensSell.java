package com.tavin.dsvendas_api.infra.models.sells;

import com.tavin.dsvendas_api.infra.models.ProductModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tb_itens_sell")
@NoArgsConstructor
public class ItensSell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sell")
    private SellModel sellModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    private ProductModel product;

    @Column
    private Integer amount;
}
