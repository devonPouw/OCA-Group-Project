package com.kahooters.ocaquiz.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    public Long ID;

    public String description;
    public Integer isCorrect;

//    @ManyToOne
//    @JsonBackReference
//    public Question question;


}
