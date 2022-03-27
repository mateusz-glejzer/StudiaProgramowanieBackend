package com.company;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class zadanie7 {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        User userObject = new User("John", 21);
        String userJson = objectMapper.writeValueAsString(userObject);

        System.out.println(userJson);
    }
    public static class User{
        private String name;
        private int age;

        public User(String name,int age)
        {
            this.age=age;
            this.name=name;
        }
        public User(){}
    }

}
