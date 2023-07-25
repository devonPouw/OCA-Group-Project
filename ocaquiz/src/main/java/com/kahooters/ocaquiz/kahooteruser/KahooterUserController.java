package com.kahooters.ocaquiz.kahooteruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/kahooteruser")
public class KahooterUserController {

    @Autowired
    KahooterUserService kahooterUserService;

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<KahooterUserDTO> onUserLogin(@RequestBody KahooterUser kahooterUser){
        System.out.println("test123");
        return kahooterUserService.handleLogin(kahooterUser);
    }

//    @PostMapping
//    @RequestMapping("/kahooteruser")
//    public KahooterUser newUser(@RequestBody KahooterUser kahooterUser){
//        return kahooterUserService.kahooterUserRepository.save(kahooterUser);
//    }
}