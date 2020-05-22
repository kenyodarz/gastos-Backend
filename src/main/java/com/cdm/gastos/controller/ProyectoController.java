package com.cdm.gastos.controller;

import com.cdm.gastos.models.Proyecto;
import com.cdm.gastos.services.ProyectoServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/proyecto/")
public class ProyectoController {

    @Autowired
    private ProyectoServiceApi proyectoServiceApi;

    @GetMapping("all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Proyecto> gerAll(){
        return proyectoServiceApi.getAll();
    }

    @GetMapping("find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Proyecto find(@PathVariable String id){
        return proyectoServiceApi.get(id);
    }

    @PostMapping("save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Proyecto> save (@RequestBody Proyecto proyecto){
        Proyecto proyecto1 = proyectoServiceApi.save(proyecto);
        return new ResponseEntity<>(proyecto1, HttpStatus.OK);
    }

    @GetMapping("delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity <Proyecto> delete (@PathVariable String id){
        Proyecto proyecto = proyectoServiceApi.get(id);
        if (proyecto != null){
            proyectoServiceApi.delete(id);
        } else {return new ResponseEntity<>(proyecto, HttpStatus.INTERNAL_SERVER_ERROR);}
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
}
