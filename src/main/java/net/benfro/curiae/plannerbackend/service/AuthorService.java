package net.benfro.curiae.plannerbackend.service;

import net.benfro.curiae.plannerbackend.domain.Author;
import net.benfro.curiae.plannerbackend.persistence.AuthorRepository;
import net.benfro.curiae.plannerbackend.util.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements BaseEntityService<Author> {

   @Autowired
   private AuthorRepository authorRepository;

   public Author findById(Long id) {
      Optional<Author> byId = authorRepository.findById(id);
      return byId.orElse(null);
   }

   public Iterable<Author> findAll() {
      return authorRepository.findAll();
   }

   @Override
   public void delete(Author toDelete) {
      authorRepository.delete(toDelete);
   }

   @Override
   public Author saveOrUpdate(Author entity) {
      return authorRepository.save(entity);
   }
}
