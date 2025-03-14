package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.infra.models.DashboardModel;
import com.tavin.dsvendas_api.repositories.client.ClientRepository;
import com.tavin.dsvendas_api.repositories.product.ProductRepository;
import com.tavin.dsvendas_api.repositories.sell.SellRepository;
import com.tavin.dsvendas_api.service.dashboard.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class dashboardController {

    private final DashboardService dashboardService;

    @GetMapping()
    public ResponseEntity<DashboardModel> getDashboard() {
        DashboardModel data = dashboardService.dataDashboard();
        return ResponseEntity.ok(data);
    }
}
