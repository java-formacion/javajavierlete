package com.ipartek.spring.booksmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ipartek.spring.booksmongo.repository.AuthorRepository;
import com.ipartek.spring.booksmongo.repository.BookRepository;
import com.ipartek.spring.booksmongo.resolver.BookResolver;
import com.ipartek.spring.booksmongo.resolver.Mutation;
import com.ipartek.spring.booksmongo.resolver.Query;

@SpringBootApplication
public class BooksMongoGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksMongoGraphqlApplication.class, args);
	}
	
	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Query(authorRepository, bookRepository);
	}
	
	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(authorRepository, bookRepository);
	}
	
}
