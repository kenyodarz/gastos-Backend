package com.cdm.gastos.controller;

import com.cdm.gastos.models.Saldo;
import com.cdm.gastos.services.SaldoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saldo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class SaldoRestController {

    @Autowired
    private SaldoServiceAPI serviceAPI;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Saldo> getAll(){
        return serviceAPI.getAll();
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Saldo find (@PathVariable Long id){
        return serviceAPI.get(id);
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Saldo> save (@RequestBody Saldo registro){
        Saldo obj = serviceAPI.save(registro);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity <Saldo> delete (@PathVariable Long id){
        Saldo saldo = serviceAPI.get(id);
        if (saldo != null){
            serviceAPI.delete(id);
        }else {return  new ResponseEntity<>(saldo, HttpStatus.INTERNAL_SERVER_ERROR);}
        return new ResponseEntity<>(saldo, HttpStatus.OK);
    }

}
