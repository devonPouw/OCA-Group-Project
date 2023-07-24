package com.kahooters.ocaquiz.Repository;

import com.kahooters.ocaquiz.Model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
