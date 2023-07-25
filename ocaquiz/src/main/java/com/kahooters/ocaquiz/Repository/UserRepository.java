package com.kahooters.ocaquiz.Repository;

import com.kahooters.ocaquiz.Model.KahooterUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<KahooterUser, Long> {
    Optional<KahooterUser> findByName(String name);
}
