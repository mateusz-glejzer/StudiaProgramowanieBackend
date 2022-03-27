package com.company;
 import com.fasterxml.jackson.core.JsonProcessingException;
 import com.fasterxml.jackson.databind.ObjectMapper;

public class zadanie8 {

    public static void main(String[] args) {


        ObjectMapper objectMapper = new ObjectMapper();

        String userJson = "{\"name\":\"John\",\"age\":21}";
        User userObject = objectMapper.readValue(userJson, User.class);

        System.out.println(userObject.getName());
        System.out.println(userObject.getAge());
    }
}
