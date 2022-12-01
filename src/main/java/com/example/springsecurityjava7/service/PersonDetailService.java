package com.example.springsecurityjava7.service;

import com.example.springsecurityjava7.entity.Person;
import com.example.springsecurityjava7.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PersonDetailService implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.getByEmail(username);
        if (person == null) {
            throw new UsernameNotFoundException("Username not found exception!");
        }
        return person;
    }
}
