package net.benfro.curiae.plannerbackend.domain;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Author implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String firstName;
   private String lastName;
   @Embedded
   private AuditData audit;
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name="AUTHOR_ITEM")
   private List<Item> items = Lists.newArrayList();


   public Author(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public void addItem(Item itemToAdd) {
      items.add(itemToAdd);
      itemToAdd.getAuthors().add(this);
   }
}
