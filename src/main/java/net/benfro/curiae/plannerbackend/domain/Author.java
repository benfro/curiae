package net.benfro.curiae.plannerbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {

   private long id;
   private String firstName;
   private String lastName;
   private AuditData audit;

}
