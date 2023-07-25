package com.kahooters.ocaquiz.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    @GetMapping("/questions/{id}")
    public Optional<Question> getQuestionById(@PathVariable("id")long id){
        return questionRepository.findById(id);
    }
    @PostMapping("/questions")
    public Question postQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }
//    @PutMapping("/questions/{id}")
//    public ResponseEntity<Question> updateQuestion(@PathVariable("id") long id, @RequestBody Question question) {
//		...
//    }

//    @DeleteMapping("/questions/{id}")
//    public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable("id") long id) {
//		return questionRepository.deleteById(id);
//    }
//
//    @DeleteMapping("/questions")
//    public ResponseEntity<HttpStatus> deleteAllQuestions() {
//		...
//    }
}
