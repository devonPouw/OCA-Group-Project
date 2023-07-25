package com.kahooters.ocaquiz.kahooteruser;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KahooterUserRepository extends CrudRepository<KahooterUser, Long> {
    Optional<KahooterUser> findByUsername(String username);
}
