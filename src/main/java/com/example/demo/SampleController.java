package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

	private static final String template = "Hello, %s!";
    
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World bitch!";
    }
    
    
    @RequestMapping(value = "/cities")
    @ResponseBody
    public String findCities() throws IOException {

       return "voici tes villes";
    }
    
    @RequestMapping("/greeting")
    @ResponseBody
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new String(String.format(template, name));
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}