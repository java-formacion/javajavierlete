# Spring Boot GraphQL API

API GraphQL con Spring Boot contra MYSQL con JPARepository.
Base de datos de Autores y Libros.

# Configuración GraphQL

**Queries y mutations**

Author.graphqls

    type Author { 
    	id: ID! 
    	firstName: String! 
    	lastName: String! 
    } 
    
    type Query { 
    	findAllAuthors: [Author]! 
    	countAuthors: Long! 
    } 
    
    type Mutation { 
    	newAuthor(firstName: String!, lastName: String!) : Author! 
    }

Book.graphqls

    type Book { 
    	id: ID! 
    	title: String! 
    	isbn: String! 
    	pageCount: Int 
    	author: Author 
    } 
    
    extend type Query { 
    	findAllBooks: [Book]!
    	countBooks: Long!
    } 
    
    extend type Mutation { 
    	newBook(title: String!, isbn: String!, pageCount: Int, author: ID!) : Book!
    	deleteBook(id: ID!) : Boolean
    }

# Queries API

Para obtener los libros

    {
      findAllBooks {
        title
        pageCount
        author {
          firstName
        }
      }
    }

Para crear un libro:

    mutation {
      newBook(
        title: "Javascript para listos", 
        isbn: "53243",
        pageCount: 2,
        author: 1
      ) {
        id,
        title
      }
    }