package com.kahooters.ocaquiz.Repository;

import com.kahooters.ocaquiz.Model.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {

}
