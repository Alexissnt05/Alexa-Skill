package org.alexis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BusJsonParser extends BusApiService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private JsonNode node;
    public BusJsonParser() {
        setJsonNode();
    }

    public JsonNode getJsonNode() {
        return node;
    }

    public void setJsonNode() {
        try {
            node = objectMapper.readTree(getJsonString());
        } catch (JsonProcessingException ignored) {
        }
    }

}
