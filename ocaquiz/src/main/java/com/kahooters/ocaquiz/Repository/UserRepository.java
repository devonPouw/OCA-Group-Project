package com.kahooters.ocaquiz.Repository;

import com.kahooters.ocaquiz.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
