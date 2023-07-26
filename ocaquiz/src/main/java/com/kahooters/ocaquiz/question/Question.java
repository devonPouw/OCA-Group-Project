package com.kahooters.ocaquiz.question;


import com.kahooters.ocaquiz.choice.Choice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String questionText;
//    public Integer points;

//    @ManyToMany(mappedBy = "questions")
//    @JsonIgnore
//    public List<Quiz> Quizzes;
//
    @OneToMany(mappedBy = "question")
    public List<Choice> choices;
//
//    @OneToMany(mappedBy = "question")
//    @JsonManagedReference
//    public List<ChosenAnswer> chosenAnswers;
//
//    @JoinTable(
//            name = "questions_tags",
//            joinColumns = @JoinColumn(name = "tag_id"),
//            inverseJoinColumns = @JoinColumn(name = "question_id")
//    )
//    public List<Tag> tags;
}
