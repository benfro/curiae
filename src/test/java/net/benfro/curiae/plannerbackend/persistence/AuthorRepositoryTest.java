package net.benfro.curiae.plannerbackend.persistence;

import net.benfro.curiae.plannerbackend.domain.Author;
import net.benfro.curiae.plannerbackend.domain.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AuthorRepositoryTest {
   @Autowired
   TestEntityManager testEntityManager;
   @Autowired
   AuthorRepository authorRepository;

   private Author author;

   @BeforeEach
   void setUp() {
      author = new Author("Johann Sebastian", "Bach");
      testEntityManager.persist(author);
   }

   @AfterEach
   void tearDown() {
      testEntityManager.remove(author);
   }

   @Test
   void testCount() {
      assertEquals(1, authorRepository.count());
   }

   @Test
   void testAddItem() {
      Author author = authorRepository.findById(1L).get();
      assertEquals("Bach", author.getLastName());
      author.addItem(new Item("Air on the G string"));
      author.addItem(new Item("Bourée"));

      Author author2 = authorRepository.findById(1L).get();
      assertEquals(2, author2.getItems().size());
   }

   @Test
   void testFindByLastName() {
      Author bach = authorRepository.findByLastName("Bach");
      assertNotNull(bach);
   }

   @Test
   void testFindByLastNameStartingWith() {
      List<Author> bach = authorRepository.findByLastNameStartingWith("B");
      assertNotNull(bach.get(0));
   }

   
}
