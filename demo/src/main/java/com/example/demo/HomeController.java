package com.example.demo;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class HomeController {
    Gson gson = new Gson();

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
    public String getUser(@RequestParam Integer key)
    {

        return gson.toJson(users.get(key));
    }
    @RequestMapping(value="/getUsers",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getUsers()
    {
        return gson.toJson(users.values());
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam Integer key)
    {

        return gson.toJson(users.remove(key))+"was deleted";
    }

    @RequestMapping("/zip")
    public String zip() {return "zip.zip";}
    @RequestMapping("/txt")
    public String tekst() {return "tekst.txt";}
}
