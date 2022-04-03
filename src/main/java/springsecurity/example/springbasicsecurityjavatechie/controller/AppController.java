package springsecurity.example.springbasicsecurityjavatechie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class AppController {

    @GetMapping("/getmessage")
    public String greeting(){
        return "Spring Security Example";
    }
}
