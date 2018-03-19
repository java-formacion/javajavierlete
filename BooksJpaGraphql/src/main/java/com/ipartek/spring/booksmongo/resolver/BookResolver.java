package com.ipartek.spring.booksmongo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.ipartek.spring.booksmongo.model.Author;
import com.ipartek.spring.booksmongo.model.Book;
import com.ipartek.spring.booksmongo.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
	
	private AuthorRepository authorRepository;

	public BookResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(Book book) {
		return authorRepository.findOne(book.getAuthor().getId());
	}
}