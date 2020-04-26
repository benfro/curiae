package net.benfro.curiae.plannerbackend.security;

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
public class User  implements Serializable {

   @Id
   @GeneratedValue
   private Long id;
   String userName;
   String password;
   String email;

}
