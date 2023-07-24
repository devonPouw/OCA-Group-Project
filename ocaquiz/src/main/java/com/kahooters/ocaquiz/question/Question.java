package com.kahooters.ocaquiz.question;


import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;
//    public Integer type;
    public String text;
//    public Integer points;

    public Question(String text, Long id) {
        this.text = text;
        this.id = id;
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
