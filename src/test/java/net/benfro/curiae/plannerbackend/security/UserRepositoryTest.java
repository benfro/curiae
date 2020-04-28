package net.benfro.curiae.plannerbackend.security;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {
   @Autowired
   TestEntityManager testEntityManager;
   @Autowired
   UserRepository userRepository;

   private User user;

   @BeforeEach
   void setUp() {
      user = new User("benfro", "password");
      testEntityManager.persist(user);
   }

   @AfterEach
   void tearDown() {
      testEntityManager.remove(user);
   }

   @Test
   void testRetrieveByUsername () {
      User benfro = userRepository.findByUsername("benfro");
      assertNotNull(benfro);
      assertEquals(1L, userRepository.count());
   }

   @Test
   void testAddAndCount () {
      userRepository.save(new User("apa", "banan"));
      userRepository.save(new User("leguan", "kött"));
      assertEquals(3L, userRepository.count());
   }
}
