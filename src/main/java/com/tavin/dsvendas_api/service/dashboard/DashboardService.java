package com.tavin.dsvendas_api.service.dashboard;

import com.tavin.dsvendas_api.infra.models.DashboardModel;
import com.tavin.dsvendas_api.repositories.client.ClientRepository;
import com.tavin.dsvendas_api.repositories.product.ProductRepository;
import com.tavin.dsvendas_api.repositories.sell.SellRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final SellRepository sellRepository;
    private final ProductRepository productRepository;
    private final ClientRepository  clientRepository;

    public DashboardModel dataDashboard() {
        long sellCount = sellRepository.count();
        long productCount = productRepository.count();
        long clientCount = clientRepository.count();

        var sellPerYear = sellRepository.GetSumPerMonth(LocalDate.now().getYear());


        return new DashboardModel(productCount,sellPerYear, clientCount, sellCount);
    }


}

