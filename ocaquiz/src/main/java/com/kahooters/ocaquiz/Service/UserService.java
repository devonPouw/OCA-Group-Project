package com.kahooters.ocaquiz.Service;

import com.kahooters.ocaquiz.Model.KahooterUser;
import com.kahooters.ocaquiz.Model.UserDTO;
import com.kahooters.ocaquiz.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<UserDTO> handleLogin(KahooterUser kahooterUser) {

            if(kahooterUser.getName() == null || kahooterUser.getName().equals("")){
                UserDTO nulldto = new UserDTO("Username is required but not given.",-1L, "Error");
                return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(nulldto);
            }
            if(kahooterUser.getPassword() == null || kahooterUser.getPassword().equals("")){
                UserDTO nulldto = new UserDTO("Password is required but not given.",-1L, "Error");
                return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(nulldto);
            }
            Optional<KahooterUser> dbUserOpt = userRepository.findByName(kahooterUser.getName());
            if(dbUserOpt.isEmpty()) {
                UserDTO nulldto = new UserDTO("Username or Password is incorrect.",-1L, "Error");
                return ResponseEntity.status(HttpStatusCode.valueOf(401)).body(nulldto);
            }

            KahooterUser dbKahooterUser = dbUserOpt.get();
            if(!dbKahooterUser.getPassword().equals(kahooterUser.getPassword())){
                UserDTO nulldto = new UserDTO("Username or Password is incorrect.",-1L, "Error");
                return ResponseEntity.status(HttpStatusCode.valueOf(401)).body(nulldto);
            }

            UserDTO userdto = new UserDTO("OK", dbKahooterUser.getId(), dbKahooterUser.getNickname());
            return ResponseEntity.ok(userdto);
    }
}
