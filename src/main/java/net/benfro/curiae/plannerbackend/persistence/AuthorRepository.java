package net.benfro.curiae.plannerbackend.persistence;

import net.benfro.curiae.plannerbackend.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
