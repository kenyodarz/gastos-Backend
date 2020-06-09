package com.cdm.gastos.controller;

import com.cdm.gastos.models.Informe;
import com.cdm.gastos.services.InformeServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/api/informe")
public class InformeController {

    @Autowired
    InformeServiceAPI serviceAPI;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Informe> getAll(){
        return serviceAPI.getAll();
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Informe find (@PathVariable Long id){
        return serviceAPI.get(id);
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Informe> save (@RequestBody Informe informe){
        Informe obj = serviceAPI.save(informe);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity <Informe> delete (@PathVariable Long id){
        Informe informe = serviceAPI.get(id);
        if (informe != null){
            serviceAPI.delete(id);
        }else {return  new ResponseEntity<>(informe, HttpStatus.INTERNAL_SERVER_ERROR);}
        return new ResponseEntity<>(informe, HttpStatus.OK);
    }
}
