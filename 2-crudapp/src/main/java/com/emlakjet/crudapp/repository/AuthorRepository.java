package com.emlakjet.crudapp.repository;

import com.emlakjet.crudapp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getByFirstNameAndAndLastNameAndTckNo(String firstName, String lastName, Long tckNo);

}
