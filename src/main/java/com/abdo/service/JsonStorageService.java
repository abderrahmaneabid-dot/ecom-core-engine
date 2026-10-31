package com.abdo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JsonStorageService {

    private final ObjectMapper objectMapper;

    public JsonStorageService() {
        this.objectMapper = new ObjectMapper();
        // Bach ykoun l-JSON m-sttef w-m-formati mezyan (Pretty Print)
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    // Sauvegarder n'importe quelle liste d'objets f-fichier JSON
    public <T> void saveToFile(String filePath, List<T> data) throws IOException {
        File file = new File(filePath);
        objectMapper.writeValue(file, data);
    }

    // Chargement dyal List d'objets mn fichier JSON
    public <T> List<T> loadFromFile(String filePath, TypeReference<List<T>> typeReference) {
        File file = new File(filePath);
        if (!file.exists()) {
            return Collections.emptyList();
        }
        try {
            return objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier " + filePath + ": " + e.getMessage());
            return Collections.emptyList();
        }
    }
}