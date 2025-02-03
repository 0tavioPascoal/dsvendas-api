package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.infra.models.sells.SellModel;
import com.tavin.dsvendas_api.repositories.itensSell.ItensSellsRepository;
import com.tavin.dsvendas_api.repositories.sell.SellRepository;
import com.tavin.dsvendas_api.service.sell.SellService;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sell")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class sellController {

    private final SellRepository  sellRepository;

    private final ItensSellsRepository itensSellsRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> sell(@RequestBody SellModel sellModel) {
        sellRepository.save(sellModel);
        sellModel.getItens().stream().forEach(itens -> itens.setSellModel(sellModel));
        itensSellsRepository.saveAll(sellModel.getItens());
        return ResponseEntity.ok().body("Sell Salvo com sucesso!");
    };

}
