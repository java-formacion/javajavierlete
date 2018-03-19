package com.ipartek.spring.booksmongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.spring.booksmongo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
