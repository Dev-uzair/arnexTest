package com.arnex.test.service;

import com.arnex.test.model.Json;
import com.arnex.test.repository.JsonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JsonService {

    private final JsonRepository jsonRepository;

    @Autowired
    public JsonService(JsonRepository jsonRepository) {
        this.jsonRepository = jsonRepository;
    }

    public List<Json> getAllJsons() {
        return jsonRepository.findAll();
    }

    public Optional<Json> getJsonById(Long id) {
        return jsonRepository.findById(id);
    }

    public Json saveJson(Json json) {
        return jsonRepository.save(json);
    }

    public Json updateJson(Long id, Json jsonDetails) {
        Json json = jsonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Json not found with id: " + id));

        json.setJsonData(jsonDetails.getJsonData());

        return jsonRepository.save(json);
    }

    public void deleteJson(Long id) {
        Json json = jsonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Json not found with id: " + id));

        jsonRepository.delete(json);
    }
}
