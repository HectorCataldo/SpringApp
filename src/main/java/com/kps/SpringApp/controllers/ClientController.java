package com.kps.SpringApp.controllers;

import com.kps.SpringApp.entities.Client;
import com.kps.SpringApp.repositories.ClientRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    private ClientRepository clientRep;

    public ClientController(ClientRepository clientRep) {
        this.clientRep = clientRep;
    }

    @GetMapping("/api/clients")
    public List<Client> findClients() {
        return clientRep.findAll();
    }

    @GetMapping("/api/clients/{id}")
    public ResponseEntity<Client> findClientbyID(@PathVariable Integer id) {
        Optional<Client> client = clientRep.findById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@PostMapping("/api/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client)
    {
        //guardar cliente en la base de datos
        try
        {
            List<Client> clientes = clientRep.findAll();
            for (Client client1 : clientes)
            {
                if (client.getDocumentNumber().equals(client1.getDocumentNumber()))
                {
                    return ResponseEntity.badRequest().build();
                }
                else
                {
                    clientRep.save(client);
                    return ResponseEntity.ok(client);
                }
            }
        }
        catch (DataAccessException e)
        {
            String errorMessage = "Error al guardar el cliente en la base de datos: " + e.getMessage();
            System.out.println(errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }*/
    @PostMapping("/api/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        try {
            List<Client> clientes = clientRep.findAll();

            for (Client existingClient : clientes) {
                if (client.getDocumentNumber().equals(existingClient.getDocumentNumber())) {
                    return ResponseEntity.badRequest().build(); // Ya existe un cliente con el mismo número de documento
                }
            }

            // No se encontró un cliente existente con el mismo número de documento, guardar el nuevo cliente
            clientRep.save(client);
            return ResponseEntity.ok(client);
        } catch (DataAccessException e) {
            String errorMessage = "Error al guardar el cliente en la base de datos: " + e.getMessage();
            System.out.println(errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
