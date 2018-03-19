package com.ipartek.spring.booksmongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.spring.booksmongo.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
