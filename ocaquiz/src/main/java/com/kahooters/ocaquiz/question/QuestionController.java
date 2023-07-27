package com.kahooters.ocaquiz.question;

import com.kahooters.ocaquiz.choice.Choice;
import com.kahooters.ocaquiz.choice.ChoiceRepository;
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
    @Autowired
    ChoiceRepository choiceRepository;

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
        questionRepository.save(question);
        for (Choice choice:question.getChoices()) {
            choice.setQuestion(question);
            choiceRepository.save(choice);
        }
        return question;
    }
    public void setChoices(Choice choice){
//        choiceRepository.save(choice);
        System.out.println(choice.getQuestion().getQuestionText());
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
