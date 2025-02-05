package com.tavin.dsvendas_api.infra.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class DashboardModel {

    private long productCount;
    private long sellCount;
    private long clientCount;
}
