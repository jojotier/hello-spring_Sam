package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "Hello, Spring!";
    }

    @GetMapping("/hello/goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST }, value = "/hello/hello-world")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String lang){
        return createMessage(name, lang);
    }

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("forms")
    public String helloWithForms(){
        return "<html>"+
                "<body>" +
                "<form action = 'hello-world' method='get'>" + //<- this line links it to the hello-world handler to let it submit
                "<input type='text' name = 'name'>" +
                "<select name='lang' id = 'lang'>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='chinese'>Chinese</option>" +
                "<option value='japanese'>Japanese</option>" +
                "</select>" +
                "<input type='submit' value = 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String lang){
        String greeting="";

        if(lang.equals("english")){
            greeting = "hello";
        }
        if(lang.equals("french")){
            greeting = "bonjour";
        }
        if(lang.equals("spanish")){
            greeting = "hola";
        }
        if(lang.equals("chinese")){
            greeting = "nihao";
        }
        if(lang.equals("japanese")){
            greeting = "konichiwa";
        }

        return greeting + ", " + name;
    }

}
