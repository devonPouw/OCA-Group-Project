package com.kahooters.ocaquiz.choice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/question")
public class ChoiceController {

    @Autowired
    ChoiceRepository choiceRepository;

    @PostMapping("/choice")
    public Choice postChoice(@RequestBody Choice choice) {
        return choiceRepository.save(choice);
    }

    @GetMapping("/choice")
    public List<Choice> getChoice(){
        return choiceRepository.findAll();
    }
}
