package com.tavin.dsvendas_api.repositories.sell.projections;

import java.math.BigDecimal;

public interface SellPerMonth {

    Integer getMonth();
    BigDecimal getValue();
}
