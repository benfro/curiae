package net.benfro.curiae.plannerbackend.persistence;

import net.benfro.curiae.plannerbackend.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
