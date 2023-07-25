package com.kahooters.ocaquiz.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long ID;
    public String name;

//    @JoinTable(
//            name = "quizes_questions",
//            joinColumns = @JoinColumn(name = "question_id"),
//            inverseJoinColumns = @JoinColumn(name = "quiz_id")
//    )
//    public List<Question> questions;
//
//    @OneToMany(mappedBy = "quiz")
//    @JsonManagedReference
//    public List<ChosenAnswer> chosenAnswers;

}