package com.tavin.dsvendas_api.infra.models;

import com.tavin.dsvendas_api.repositories.sell.projections.SellPerMonth;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardModel {

    private long productCount;
    private long sellCount;
    private long clientCount;
    private List<SellPerMonth> sellPerMonth;

    public DashboardModel(long productCount, List<SellPerMonth> sellPerMonth, long clientCount, long sellCount) {
        this.productCount = productCount;
        this.sellPerMonth = sellPerMonth;
        this.clientCount = clientCount;
        this.sellCount = sellCount;
        this.addMonthNull();
    }

    public List<SellPerMonth> getSellPerMonth() {
        if (sellPerMonth == null) {
            sellPerMonth = new ArrayList<>();
        }
        return sellPerMonth;
    }

    public void addMonthNull() {
        Integer mesMaximo = getSellPerMonth()
                .stream()
                .mapToInt(SellPerMonth::getMonth)
                .max().orElse(0); // Melhor forma de lidar com Optional

        List<Integer> listaMeses = IntStream
                .rangeClosed(1, mesMaximo)
                .boxed().toList();

        List<Integer> mesesAdicionados = getSellPerMonth()
                .stream()
                .map(SellPerMonth::getMonth)
                .toList();

        listaMeses.forEach(mes -> {
            if (!mesesAdicionados.contains(mes)) {
                SellPerMonth vendaPorMes = new SellPerMonth() {

                    @Override
                    public Integer getMonth() {
                        return mes;
                    }

                    @Override
                    public BigDecimal getValue() {
                        return BigDecimal.ZERO;
                    }

                };
                getSellPerMonth().add(vendaPorMes);
            }
        });

        getSellPerMonth().sort(Comparator.comparing(SellPerMonth::getMonth));
    }
}
