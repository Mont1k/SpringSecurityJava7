package com.example.springsecurityjava7.repository;

import com.example.springsecurityjava7.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query ("select p from Person p where p.email = :email")
    Person getByEmail(@Param("email")String email);
}