package com.cdm.gastos.controller;

import com.cdm.gastos.models.RegistroEntrada;
import com.cdm.gastos.services.RegistroServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registro")
@CrossOrigin (origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class RegistroController {

    @Autowired
    private RegistroServiceAPI registroServiceAPI;


    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<RegistroEntrada> getAll(){
        return registroServiceAPI.getAll();
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public RegistroEntrada find (@PathVariable Long id){
        return registroServiceAPI.get(id);
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<RegistroEntrada> save (@RequestBody RegistroEntrada registro){
        RegistroEntrada obj = registroServiceAPI.save(registro);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity <RegistroEntrada> delete (@PathVariable Long id){
        RegistroEntrada registro = registroServiceAPI.get(id);
        if (registro != null){
            registroServiceAPI.delete(id);
        }else {return  new ResponseEntity<>(registro, HttpStatus.INTERNAL_SERVER_ERROR);}
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

}
