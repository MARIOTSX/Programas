package core.udemy.springU.springU.repositories;

import org.springframework.data.repository.CrudRepository;

import core.udemy.springU.springU.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
