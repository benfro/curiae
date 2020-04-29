package net.benfro.curiae.plannerbackend.persistence;

import net.benfro.curiae.plannerbackend.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
   Author findByLastName(String lastName);
   List<Author> findByLastNameStartingWith(String startWith);
}
