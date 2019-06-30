package io.management.IntroductionController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Handles HTTP request directly
public class ManagementController {

    @RequestMapping("/hello") //Default requestMapping is a GET request
    public String sayHello(){
        return "Hello";
    }
}
