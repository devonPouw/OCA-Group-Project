package com.kahooters.ocaquiz.choice;

import com.kahooters.ocaquiz.question.Question;
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
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String description;

    private Boolean isCorrect;

    private String feedback;

    @ManyToOne
    private Question question;


}
