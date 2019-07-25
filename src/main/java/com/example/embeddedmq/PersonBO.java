package com.example.embeddedmq;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class PersonBO extends JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Object oc = jp.getCodec();
        JsonNode node = ((ObjectCodec) oc).readTree(jp);



        return new Person(
                node.get("id").asText(),
                node.get("pass").asText()
        ) ;
    }

}
