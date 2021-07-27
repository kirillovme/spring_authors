package dkirillov.springframework.spring5webapp.repositories;

import dkirillov.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
