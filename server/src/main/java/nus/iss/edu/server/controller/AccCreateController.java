package nus.iss.edu.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import nus.iss.edu.server.service.AccCreateService;

@Controller
@CrossOrigin(origins = "*")
public class AccCreateController {
    
    @Autowired
    private AccCreateService service;

    @PostMapping("/newAccount")
    @ResponseBody()
    public ResponseEntity<String> insertAccount(@RequestBody String payload){

        String id = service.insertAccount(payload);
        System.out.println(">>>>>> id" + id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

    @GetMapping("/allAccounts")
    @ResponseBody()
    public ResponseEntity<String> getAllAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllAccounts().toString());
    }

    @PostMapping("/transferAccount")
    @ResponseBody()
    public ResponseEntity<String> insertTransferAcc(@RequestBody String payload){

        System.out.println(payload);
        String id = service.insertTransferAccount(payload);
        return ResponseEntity.status(HttpStatus.OK).body(id);
        
    }
}
