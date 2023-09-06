package com.kps.SpringApp.controllers;

import com.kps.SpringApp.entities.Profession;
import com.kps.SpringApp.repositories.ProfessionRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfessionController {
    @Autowired
    private ProfessionRepository pr;

    private final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Operation(summary = "Get a list of profession in bd")
    @GetMapping("/api/profession")
    public ResponseEntity<List<Profession>> findAllProfession(){
        try{
            return ResponseEntity.ok(pr.findAll());
        }
        catch (DataAccessException e){
            String errorMessage = "Error al obtener las profesiones de la base de datos "+e.getMessage() ;
            log.warn(errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Get a profession by id")
    @GetMapping("/api/profession/{id}")
    public ResponseEntity<Profession> findProfessionById(@PathVariable Integer id){
        try {
            Optional<Profession> profession = pr.findById(id);
            if (profession.isPresent()){
                return ResponseEntity.ok(profession.get());
            }
            else {
                log.warn("La profesión que busca no existe");
                return ResponseEntity.notFound().build();
            }
        }
        catch (DataAccessException e){
            String errorMessage = "Error al traer los clientes de la base de datos "+e.getMessage() ;
            log.warn(errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Create a profession in bd")
    @PostMapping("/api/profession")
    public ResponseEntity<Profession> createProfession(@RequestBody Profession profession){
        try {
            List<Profession> professions = pr.findAll();
            for (Profession p : professions){
                if (p.getProfession_Name().equals(profession.getProfession_Name())){
                    log.warn("Se intenta registrar una profesión que ya existe");
                    return ResponseEntity.badRequest().build();
                }
            }
            pr.save(profession);
            return ResponseEntity.ok(profession);
        }
        catch (DataAccessException e){
            String errorMessage = "Error al guardar la profesión en la base de datos: " + e.getMessage();
            log.warn(errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Update data of a Profession")
    @PutMapping("/api/profession")
    public ResponseEntity<Profession> UpdateProfession(@RequestBody Profession profession){
        try {
            List<Profession> professions = pr.findAll();
            for (Profession p : professions){
               if (p.getProfession_Name().equals(profession.getProfession_Name()) && profession.getId_profession() != p.getId_profession() ){
                   log.warn("No puede ingresar una profesión existente");
                   return ResponseEntity.badRequest().build();
               }
            }
            Optional<Profession> prf = pr.findById(profession.getId_profession());
            if (prf.isPresent()){
                pr.save(profession);
                return ResponseEntity.ok(profession);
            }
            else {
                log.warn("La profesión que intenta actualizar no existe");
                return ResponseEntity.notFound().build();
            }
        }
        catch (DataAccessException e){
            String errorMessage = "Error al actualizar datos de la profesión: " + e.getMessage();
            log.warn(errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @Operation(summary = "Delete a profession by id")
    @DeleteMapping("/api/profession/{id}")
    public ResponseEntity<List<Profession>> deleteProfessionById(@PathVariable Integer id){
        try{
            Optional<Profession> prf = pr.findById(id);
            if (prf.isPresent()){
                pr.deleteById(id);
                return ResponseEntity.ok(pr.findAll());
            }
            else {
                log.warn("La profesión que desea borrar no existe");
                return ResponseEntity.notFound().build();
            }
        }
        catch (DataAccessException e){
            String errorMessage = "Error al tratar de borrar la profesión de la base de datos" + e.getMessage();
            log.warn(errorMessage);
            return null;
        }

    }

}
