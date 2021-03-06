package net.benfro.curiae.plannerbackend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorTest {
   private Author author;

   @BeforeEach
   void setUp() {
      author = new Author("Apa", "Johansson");
   }

   @Test
   void getFirstName() {
      assertEquals("Apa", author.getFirstName());
   }

   @Test
   void getLastName() {
      assertEquals("Johansson", author.getLastName());
   }
}
