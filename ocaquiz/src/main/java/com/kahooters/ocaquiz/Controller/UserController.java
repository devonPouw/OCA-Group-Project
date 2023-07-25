package com.kahooters.ocaquiz.Controller;

import com.kahooters.ocaquiz.Model.KahooterUser;
import com.kahooters.ocaquiz.Model.UserDTO;
import com.kahooters.ocaquiz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<UserDTO> onUserLogin(@RequestBody KahooterUser kahooterUser){
        System.out.println("test123");
        return userService.handleLogin(kahooterUser);
    }

}
