package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.service.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReportService reportService;

    @GetMapping()
    public ResponseEntity<byte[]> getReport(
            @RequestParam(value = "idClient", defaultValue = "0", required = false) Long idClient,
            @RequestParam(value = "startDate", defaultValue = "", required = false) String startDate,
            @RequestParam(value = "finalDate", required = false, defaultValue = "") String finalDate
            ){
        byte[] reports = reportService.generatedRelatorioVendas(idClient, startDate, finalDate);

        HttpHeaders headers = new HttpHeaders();
        var filename = "relatorios-vendas.pdf";
        headers.setContentDispositionFormData("inline; filename=\"" +filename+ "\"", filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(reports, headers, HttpStatus.OK);
    }
}
