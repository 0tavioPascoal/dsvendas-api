package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.infra.models.sells.SellModel;
import com.tavin.dsvendas_api.repositories.itensSell.ItensSellsRepository;
import com.tavin.dsvendas_api.repositories.sell.SellRepository;
import com.tavin.dsvendas_api.service.sell.SellService;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sell")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class sellController {

    private final SellService  sellService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> sell(@RequestBody SellModel sellModel) {
       return new ResponseEntity<>(sellService.CreateSell(sellModel), HttpStatus.OK);
    };

}
