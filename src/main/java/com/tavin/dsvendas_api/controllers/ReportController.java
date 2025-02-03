package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.service.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReportService reportService;

    @GetMapping()
    public ResponseEntity<byte[]> getReport() {
        byte[] reports = reportService.generatedRelatorioVendas();

        HttpHeaders headers = new HttpHeaders();
        var filename = "relatorios-vendas.pdf";
        headers.setContentDispositionFormData("inline; filename=\"" +filename+ "\"", filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(reports, headers, HttpStatus.OK);
    }
}
