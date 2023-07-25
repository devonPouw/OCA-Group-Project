package com.kahooters.ocaquiz.question;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    private String text;
//    public Integer points;

//    private Question(){}
//    public Question(String text, Long id) {
//        this.text = text;
//        this.id = id;
//    }

//    @ManyToMany(mappedBy = "questions")
//    @JsonIgnore
//    public List<Quiz> Quizzes;
//
//    @OneToMany(mappedBy = "question")
//    @JsonManagedReference
//    public List<Choice> choices;
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
