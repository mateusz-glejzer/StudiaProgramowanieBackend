package com.company;
 import com.fasterxml.jackson.core.JsonProcessingException;
 import com.fasterxml.jackson.databind.ObjectMapper;

public class zadanie8 {

    public static void main(String[] args) throws JsonProcessingException {


        ObjectMapper objectMapper = new ObjectMapper();

        String userJson = "{\"name\":\"John\",\"age\":21}";
        User userObject = objectMapper.readValue(userJson, User.class);

        System.out.println(userObject.getName());
        System.out.println(userObject.getAge());
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

        public String getName()
        {
            return name;
        }
        public String getAge()
        {
            return name;
        }
    }
}
