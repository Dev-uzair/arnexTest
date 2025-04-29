package com.arnex.test;

import com.arnex.test.model.Json;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JsonApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void testCreateJson() {
        Json json = new Json();
        json.setJsonData("{\"name\":\"Test User\",\"age\":25,\"email\":\"test@example.com\"}");

        ResponseEntity<Json> postResponse = restTemplate.postForEntity(
                getRootUrl() + "/json", json, Json.class);
        
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
    }

    @Test
    public void testGetAllJsons() {
        ResponseEntity<Json[]> response = restTemplate.getForEntity(
                getRootUrl() + "/json", Json[].class);
        
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetJsonById() {
        // First create a JSON record
        Json json = new Json();
        json.setJsonData("{\"name\":\"Get Test\",\"age\":30}");
        
        ResponseEntity<Json> postResponse = restTemplate.postForEntity(
                getRootUrl() + "/json", json, Json.class);
        
        Long id = postResponse.getBody().getJsonId();
        
        // Then retrieve it by ID
        ResponseEntity<Json> getResponse = restTemplate.getForEntity(
                getRootUrl() + "/json/" + id, Json.class);
        
        assertNotNull(getResponse.getBody());
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
    }

    @Test
    public void testUpdateJson() {
        // First create a JSON record
        Json json = new Json();
        json.setJsonData("{\"name\":\"Update Test\",\"age\":35}");
        
        ResponseEntity<Json> postResponse = restTemplate.postForEntity(
                getRootUrl() + "/json", json, Json.class);
        
        Long id = postResponse.getBody().getJsonId();
        
        // Then update it
        Json updatedJson = new Json();
        updatedJson.setJsonData("{\"name\":\"Updated Test\",\"age\":36}");
        
        HttpEntity<Json> requestEntity = new HttpEntity<>(updatedJson);
        
        ResponseEntity<Json> putResponse = restTemplate.exchange(
                getRootUrl() + "/json/" + id, HttpMethod.PUT, requestEntity, Json.class);
        
        assertNotNull(putResponse.getBody());
        assertEquals(HttpStatus.OK, putResponse.getStatusCode());
    }

    @Test
    public void testDeleteJson() {
        // First create a JSON record
        Json json = new Json();
        json.setJsonData("{\"name\":\"Delete Test\",\"age\":40}");
        
        ResponseEntity<Json> postResponse = restTemplate.postForEntity(
                getRootUrl() + "/json", json, Json.class);
        
        Long id = postResponse.getBody().getJsonId();
        
        // Then delete it
        restTemplate.delete(getRootUrl() + "/json/" + id);
        
        // Verify it's deleted
        ResponseEntity<Json> getResponse = restTemplate.getForEntity(
                getRootUrl() + "/json/" + id, Json.class);
        
        assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatusCode());
    }
}
