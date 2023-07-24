package com.kahooters.ocaquiz.question;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    public Integer type;
    public String text;
//    public Integer points;

    public Question(String text) {
        this.text = text;
    }

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
