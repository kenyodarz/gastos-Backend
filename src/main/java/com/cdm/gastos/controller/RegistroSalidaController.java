package com.cdm.gastos.controller;

import com.cdm.gastos.models.RegistroSalida;
import com.cdm.gastos.services.RegistroSalidaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registroSalida")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class RegistroSalidaController {

    @Autowired
    private RegistroSalidaServiceAPI registroServiceAPI;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<RegistroSalida> getAll(){
        return registroServiceAPI.getAll();
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public RegistroSalida find (@PathVariable Long id){
        return registroServiceAPI.get(id);
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<RegistroSalida> save (@RequestBody RegistroSalida registro){
        RegistroSalida obj = registroServiceAPI.save(registro);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity <RegistroSalida> delete (@PathVariable Long id){
        RegistroSalida registro = registroServiceAPI.get(id);
        if (registro != null){
            registroServiceAPI.delete(id);
        }else {return  new ResponseEntity<>(registro, HttpStatus.INTERNAL_SERVER_ERROR);}
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

}
