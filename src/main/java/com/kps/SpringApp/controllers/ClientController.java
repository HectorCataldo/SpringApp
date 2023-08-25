package com.kps.SpringApp.controllers;

import com.kps.SpringApp.entities.Client;
import com.kps.SpringApp.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    private final Logger log = LoggerFactory.getLogger(ClientController.class);

    private ClientRepository clientRep;

    public ClientController(ClientRepository clientRep) {
        this.clientRep = clientRep;
    }

    @GetMapping("/api/clients")
    public ResponseEntity<List<Client>> findClients()
    {
        try {
            return ResponseEntity.ok(clientRep.findAll());
        }
        catch (DataAccessException e){
            String errorMessage = "Error al traer los clientes de la base de datos "+e.getMessage() ;
            log.warn(errorMessage);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/api/clients/{id}")
    public ResponseEntity<Client> findClientbyID(@PathVariable Integer id) {
        try{
            Optional<Client> client = clientRep.findById(id);
            if (client.isPresent()) {
                return ResponseEntity.ok(client.get());
            } else {
                log.warn("El cliente que busca no existe");
                return ResponseEntity.notFound().build();
            }
        }
        catch (DataAccessException e){
            String errorMessage = "Error al buscar cliente en la base de datos" + e.getMessage();
            log.warn(errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PostMapping("/api/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        try {
            List<Client> clientes = clientRep.findAll();

            for (Client existingClient : clientes) {
                if (client.getDocumentNumber().equals(existingClient.getDocumentNumber())) {
                    log.warn("Estas tratando de crear un cliente con un número de Documento Existente");
                    return ResponseEntity.badRequest().build(); // Ya existe un cliente con el mismo número de documento
                }
            }

            // No se encontró un cliente existente con el mismo número de documento, guardar el nuevo cliente
            clientRep.save(client);
            return ResponseEntity.ok(client);
        } catch (DataAccessException e) {
            String errorMessage = "Error al guardar el cliente en la base de datos: " + e.getMessage();
            log.warn(errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/api/clients")
    public ResponseEntity<Client> updateClient (@RequestBody Client client){
        try{
            List<Client> clientes = clientRep.findAll();

            for (Client cliente : clientes){
                if(cliente.getDocumentNumber().equals(client.getDocumentNumber()) && cliente.getId() != client.getId()){
                    log.warn("No puede ingresar un número de documento de otro cliente existente para actualizar");
                    return ResponseEntity.badRequest().build();
                }
            }
            Optional<Client> OpClient = clientRep.findById(client.getId());
            if (OpClient.isPresent()){
                clientRep.save(client);
                return ResponseEntity.ok(client);
            }
            else {
                log.warn("El cliente que busca no existe en la base de datos");
                return ResponseEntity.notFound().build();
            }

        }
        catch (DataAccessException e){
            String errorMessage = "Error al Actualizar datos del cliente en la base de datos: " + e.getMessage();
            log.warn(errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/api/clients/{id}")
    public ResponseEntity<List<Client>> deleteClientByID(@PathVariable Integer id){
        try{
            Optional<Client> Opclient = clientRep.findById(id);
            if (Opclient.isPresent()){
                clientRep.deleteById(id);
                return ResponseEntity.ok(clientRep.findAll());
            }
            else {
                log.warn("El cliente con id "+ id + " no existe en la base de datos");
                return ResponseEntity.notFound().build();
            }
        }
        catch (DataAccessException e){
            String errorMessage = "Error al tratar de borrar un cliente de la base de datos" + e.getMessage();
            log.warn(errorMessage);
            return null;
        }
    }

}
