package net.benfro.curiae.plannerbackend.persistence;

import net.benfro.curiae.plannerbackend.domain.AuditData;
import net.benfro.curiae.plannerbackend.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class AuthorRepositoryTest {
   @Autowired
   TestEntityManager testEntityManager;
   @Autowired
   AuthorRepository authorRepository;

   @Test
   void name() {
      Author author = new Author(1L, "Johann Sebastian", "Bach", new AuditData());
      authorRepository.save(author);
   }
}
