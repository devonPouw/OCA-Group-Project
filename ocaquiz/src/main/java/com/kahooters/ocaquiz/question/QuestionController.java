package com.kahooters.ocaquiz.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/questions/")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping()
    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Question> getQuestionById(@PathVariable("id")long id){
        return questionRepository.findById(id);
    }
    @PostMapping
    public Question postQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }
}
