package com.kahooters.ocaquiz.kahooteruser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KahooterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private String username;
    private String password;
    private String nickname;


}