package net.benfro.curiae.plannerbackend.domain;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Item implements Serializable {

   @Id
   @GeneratedValue
   private Long id;
   @NonNull
   private String title;
   private String subTitle;
   private String opus;
   private AuditData audit = new AuditData();
   @ManyToMany(mappedBy = "items")
   private List<Author> authors = Lists.newArrayList();

   public Item(String title) {
      this.title = title;
   }
}
