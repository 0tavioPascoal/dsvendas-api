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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ReportService {

    private final DataSource dataSource;

    @Value("classpath:reports/relatorio-vendas.jrxml")
    private Resource resource;

    public byte[] generatedRelatorioVendas(Long idClient, String finalDate, String startDate){
    try(Connection conn = dataSource.getConnection()){
      JasperReport jasperCompiled = JasperCompileManager.compileReport(resource.getInputStream());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date finalDateFormated = dateFormat.parse(startDate);
        Date startDateFormated = dateFormat.parse(finalDate);

      Map<String, Object> parameters = new HashMap<>();
      parameters.put("ID_CLIENT", idClient);
      parameters.put("FINAL_DATE", finalDateFormated);
      parameters.put("START_DATE", startDateFormated);
       JasperPrint print = JasperFillManager.fillReport(jasperCompiled, parameters, conn);

       return JasperExportManager.exportReportToPdf(print);

    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (JRException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
    }}
