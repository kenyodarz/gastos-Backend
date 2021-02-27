package com.cdm.gastos.controller;

import com.cdm.gastos.models.Description;
import com.cdm.gastos.services.DescriptionServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/api/description")
public class DescripcionController {

    @Autowired
    private DescriptionServiceAPI descriptionServiceAPI;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Description> getAll() {
        return descriptionServiceAPI.getAll();
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Description find(@PathVariable Long id) {
        return descriptionServiceAPI.get(id);
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Description> save(@RequestBody Description description) {
        Description description1 = descriptionServiceAPI.save(description);
        return new ResponseEntity<>(description1, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Description> delete(@PathVariable Long id) {
        Description description = descriptionServiceAPI.get(id);
        if (description != null) {
            descriptionServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(description, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(description, HttpStatus.OK);
    }


}
