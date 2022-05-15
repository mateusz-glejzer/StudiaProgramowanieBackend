package com.example.demo;

public class UserEntity {
    public Integer id;
    public String name;
    public Integer age;

    public UserEntity(String name, Integer age,Integer id)
    {
        this.age=age;
        this.name=name;
        this.id=id;
    }
}
