package net.benfro.curiae.plannerbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author implements Serializable {

   @Id
   @GeneratedValue
   private long id;
   private String firstName;
   private String lastName;
   private AuditData audit;

}
