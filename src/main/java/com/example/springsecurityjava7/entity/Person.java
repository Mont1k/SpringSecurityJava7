package com.example.springsecurityjava7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @SequenceGenerator(name="person_seq",sequenceName = "person_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "person_seq")
    private Long id;
    private String name;
    private int age;
    private String email;
    private String password;

    public Person(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }
    @ManyToMany(cascade = ALL,fetch = FetchType.EAGER,mappedBy = "personList")
    private Set<Role> roles = new HashSet<>();
}
