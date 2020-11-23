package com.cdm.gastos.controller;

import com.cdm.gastos.models.Informe;
import com.cdm.gastos.services.InformeServiceAPI;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/api/informe")
public class InformeController {

    @Autowired
    InformeServiceAPI serviceAPI;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Informe> getAll() {
        return serviceAPI.getAll();
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Informe find(@PathVariable Long id) {
        return serviceAPI.get(id);
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Informe> save(@RequestBody Informe informe) {
        Informe obj = serviceAPI.save(informe);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Informe> delete(@PathVariable Long id) {
        Informe informe = serviceAPI.get(id);
        if (informe != null) {
            serviceAPI.delete(id);
        } else {
            return new ResponseEntity<>(informe, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(informe, HttpStatus.OK);
    }

    @GetMapping("pdf/{id}")
    public ResponseEntity<?> verArchivo(@PathVariable Integer id) throws FileNotFoundException, JRException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SERVICIOS", "postgres", "cdm");
        } catch (ClassNotFoundException | SQLException ignored) {
        }
        String sourceFileName = ResourceUtils
                .getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "InformeGastos.jrxml")
                .getAbsolutePath();

        JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("IDINFORME", id);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
        Resource resource = new ByteArrayResource(JasperExportManager.exportReportToPdf(jasperPrint));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(resource);
    }
}
