package com.tavin.dsvendas_api.service.sell;

import com.tavin.dsvendas_api.infra.dto.sell.SellRequestDto;
import com.tavin.dsvendas_api.infra.models.sells.SellModel;
import com.tavin.dsvendas_api.repositories.itensSell.ItensSellsRepository;
import com.tavin.dsvendas_api.repositories.sell.SellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellService {

    private final SellRepository sellRepository;
    private final ItensSellsRepository itensSellsRepository;

    public String CreateSell(SellModel sellModel) {
        sellRepository.save(sellModel);
        sellModel.getItens().forEach(itens -> itens.setSellModel(sellModel));
        itensSellsRepository.saveAll(sellModel.getItens());
        return "Sell Salvo com sucesso!";
    }
}
