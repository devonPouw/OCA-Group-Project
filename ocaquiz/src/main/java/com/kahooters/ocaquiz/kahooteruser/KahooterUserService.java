package com.kahooters.ocaquiz.kahooteruser;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class KahooterUserService {

    @Autowired
    KahooterUserRepository kahooterUserRepository;

    public ResponseEntity<KahooterUserDTO> handleLogin(KahooterUser kahooterUser) {

        if(kahooterUser.getUsername() == null || kahooterUser.getUsername().equals("")){
            KahooterUserDTO nulldto = new KahooterUserDTO("Username is required but not given.",-1L, "Error");
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(nulldto);
        }
        if(kahooterUser.getPassword() == null || kahooterUser.getPassword().equals("")){
            KahooterUserDTO nulldto = new KahooterUserDTO("Password is required but not given.",-1L, "Error");
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(nulldto);
        }
        Optional<KahooterUser> dbUserOpt = kahooterUserRepository.findByUsername(kahooterUser.getUsername());
        if(dbUserOpt.isEmpty()) {
            KahooterUserDTO nulldto = new KahooterUserDTO("Username or Password is incorrect.",-1L, "Error");
            return ResponseEntity.status(HttpStatusCode.valueOf(401)).body(nulldto);
        }

        KahooterUser dbKahooterUser = dbUserOpt.get();
        if(!dbKahooterUser.getPassword().equals(kahooterUser.getPassword())){
            KahooterUserDTO nulldto = new KahooterUserDTO("Username or Password is incorrect.",-1L, "Error");
            return ResponseEntity.status(HttpStatusCode.valueOf(401)).body(nulldto);
        }

        KahooterUserDTO userdto = new KahooterUserDTO("OK", dbKahooterUser.getId(), dbKahooterUser.getNickname());
        return ResponseEntity.ok(userdto);
    }
}