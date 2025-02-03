package com.tavin.dsvendas_api.service.report;


import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ReportService {

    private final DataSource dataSource;

    @Value("classpath:reports/relatorio-vendas.jrxml")
    private Resource resource;

    public byte[] generatedRelatorioVendas(){
    try(Connection conn = dataSource.getConnection()){
      JasperReport jasperCompiled = JasperCompileManager.compileReport(resource.getInputStream());
      Map<String, Object> parameters = new HashMap<>();
       JasperPrint print = JasperFillManager.fillReport(jasperCompiled, parameters, conn);

       return JasperExportManager.exportReportToPdf(print);

    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (JRException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }}}
