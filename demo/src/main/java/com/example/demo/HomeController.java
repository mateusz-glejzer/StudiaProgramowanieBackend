package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class HomeController {

    private Map<Integer,UserEntity> users = new HashMap<Integer,UserEntity>();
    int numberOfUsers;
    @RequestMapping("/test")
    public String index()
    {
        return "Hello World";
    }
    @RequestMapping("/template")
    public String template()
    {
        return "template.html";
    }
    @RequestMapping("/tree")
    public String monke()
    {
        return "monke.jpg";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String user(@RequestParam String name, @RequestParam Integer age)
    {
        users.put(numberOfUsers,new UserEntity(name,age));
        numberOfUsers++;
        return "added user:"+name;
    }
    @RequestMapping("/getUser")
    @ResponseBody
    public UserEntity getUser(@RequestParam Integer key)
    {

        return users.get(key);
    }
    @RequestMapping("/deleteUsers")
    @ResponseBody
    public Collection<UserEntity> deleteUsers()
    {
        return users.values();
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    public UserEntity deleteUser(@RequestParam Integer key)
    {

        return users.remove(key);
    }

    @RequestMapping("/zip")
    public String zip() {return "zip.zip";}
    @RequestMapping("/txt")
    public String tekst() {return "tekst.txt";}
}
