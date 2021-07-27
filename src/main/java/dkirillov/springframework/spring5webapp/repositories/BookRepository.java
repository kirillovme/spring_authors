package dkirillov.springframework.spring5webapp.repositories;

import dkirillov.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
