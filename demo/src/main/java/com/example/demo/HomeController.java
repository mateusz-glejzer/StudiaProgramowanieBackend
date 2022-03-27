package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    List users = new ArrayList<UserEntity>();
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
    @RequestMapping("/monke")
    public String monke()
    {
        return "monke.jpg";
    }
    @RequestMapping("/addusers")
    @ResponseBody
    public String user(@RequestParam int number, @RequestParam String name)
    {
        users.add(number,name);
        return "added user:"+number+name;
    }
}
