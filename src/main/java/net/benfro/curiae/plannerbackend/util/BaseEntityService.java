package net.benfro.curiae.plannerbackend.util;

public interface BaseEntityService<T> {

   T findById(Long id);

   Iterable<T> findAll();

   void delete(T toDelete);

   T saveOrUpdate(T entity);
}
