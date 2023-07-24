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
public class ChosenAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long ID;
    public Integer input;

    @ManyToOne
    @JsonBackReference
    public Quiz quiz;

    @ManyToOne
    @JsonBackReference
    public Question question;

    @ManyToOne
    @JsonBackReference
    public User user;








}
