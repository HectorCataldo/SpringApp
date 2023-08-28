package com.kps.SpringApp.controllers;

import com.kps.SpringApp.entities.Client;
import com.kps.SpringApp.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientControllerTest {
    @Autowired
    private ClientRepository clientRepository;

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findClients() {
        ResponseEntity<Client[]> response =
                testRestTemplate.getForEntity("/api/clients", Client[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Client> clients = Arrays.asList(response.getBody());
        System.out.println(clients.size());
    }

    @Test
    void findClientbyID() {
        Client client = new Client(null,"20.581.217-2","Hector", "Cataldo", LocalDate.of(2001,05,23));
        clientRepository.save(client);

        ResponseEntity<Client> response =
                testRestTemplate.getForEntity("/api/clients/1", Client.class);
        System.out.println(client.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
    }

    @Test
    void createClient() {
        //CREANDO REQUEST HTTP, SE CREA LOS HEADERS DE LA RESPUESTA HTTP
        HttpHeaders headers = new HttpHeaders();
        //SE CAMBIA EL TIPO DE ARCHIVO QUE SE ENVIA, EN ESTE CASO, MANDAMOS UN JSON
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //DEFINIMOS EL JSON
        String json = """
                {
                  "id": null,
                  "documentNumber": "19.145.132-2",
                  "firstName": "Juan Carlos",
                  "lastName": "Bodoque",
                  "birthDate": "2000-10-13"
                }
                """;
        //SE CREA EL REQUEST COMPLETO
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        //SE GENERA EL RESPONSE
        ResponseEntity<Client> response = testRestTemplate.exchange("/api/clients", HttpMethod.POST, request, Client.class);
        //OBTENEMOS EL CUERPO DEL RESPONSE
        Client client = response.getBody();
        //PROBAMOS
        assertEquals(1,client.getId());
        assertEquals("Juan Carlos", client.getFirstName());
    }

    @Test
    void updateClient() {
        //----------------OPCIONAL, CREANDO UN CLIENTE PARA ACTUALIZAR CON EXITO
        Client cliente = new Client(null,"20.581.217-2","Hector", "Cataldo", LocalDate.of(2001,05,23));
        clientRepository.save(cliente);

        //----------------CREANDO REQUEST HTTP, SE CREA LOS HEADERS DE LA RESPUESTA HTTP
        HttpHeaders headers = new HttpHeaders();
        //SE CAMBIA EL TIPO DE ARCHIVO QUE SE ENVIA, EN ESTE CASO, MANDAMOS UN JSON
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //DEFINIMOS EL JSON
        String json = """
                {
                  "id": 1,
                  "documentNumber": "20.581.217-2",
                  "firstName": "Juan Carlos",
                  "lastName": "Bodoque",
                  "birthDate": "2001-05-23"
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Client> response = testRestTemplate.exchange("/api/clients", HttpMethod.PUT, request, Client.class);
        Client client = response.getBody();

        //Buscamos que se haya cambiado el cliente con el update
        //assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());

        assertEquals("Juan Carlos", client.getFirstName());
        assertEquals(1, client.getId());
    }

    @Test
    void deleteClientByID() {
        ResponseEntity<Client[]> response = testRestTemplate.getForEntity("/api/clients/1",Client[].class);
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());

    }
    @Test
    void deleteClientByIDTest() {
        Client cliente = new Client(null,"20.581.217-2","Hector", "Cataldo", LocalDate.of(2001,05,23));
        clientRepository.save(cliente);
        ResponseEntity<Client> response = testRestTemplate.getForEntity("/api/clients/1",Client.class);
        //assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}