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
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long ID;
    public Integer type;
    public Integer text;
    public Integer points;

    @ManyToMany(mappedBy = "questions")
    @JsonIgnore
    public List<Quiz> Quizes;

    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    public List<Choice> choices;

    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    public List<ChosenAnswer> chosenAnswers;

    @JoinTable(
            name = "questions_tags",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    public List<Tag> tags;
}
