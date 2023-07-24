package com.kahooters.ocaquiz.question;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/questions")
public class QuestionController {

    @GetMapping
    public Question newQuestion(){
        return new Question("Do you like blueberries?");
    }
}
