package net.benfro.curiae.plannerbackend.domain;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item implements Serializable {

   @Id
   @GeneratedValue
   private Long id;

   private String title;

   private String subTitle;

   private String opus;
   @OneToMany
   private List<Author> items = Lists.newArrayList();
}
