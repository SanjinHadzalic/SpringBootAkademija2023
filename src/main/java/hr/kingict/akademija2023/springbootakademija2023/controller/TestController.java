package hr.kingict.akademija2023.springbootakademija2023.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/test")
public class TestController {
    @GetMapping(value = "/get")
    public String testGet(){
        return "OK";
    }

    @GetMapping(value="/get/{param}")
    public String testGetWithParam(@PathVariable String param){
        return param;
    }
    @GetMapping(value = "/getResponse")
    public ResponseEntity<String> testResponseGet(){
        return ResponseEntity
                .internalServerError()
                .header("testniHeader", "blabla")
                .body("Greska");
    }
}
