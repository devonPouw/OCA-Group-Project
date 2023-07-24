//package com.kahooters.ocaquiz.Tag;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.kahooters.ocaquiz.Question.Question;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Tag {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public Long ID;
//    public String name;
//
//    @ManyToMany(mappedBy = "tags")
//    @JsonIgnore
//    public List<Question> questions;
//
//}
