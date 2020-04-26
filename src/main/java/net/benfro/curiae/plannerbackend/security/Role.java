package net.benfro.curiae.plannerbackend.security;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
public class Role implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String role;
   @ManyToMany(mappedBy = "roles")
   private List<User> users = Lists.newArrayList();
   @ManyToMany
   @JoinTable(name="ROLE_AUTHORITY")
   private List<Authority> authorities = Lists.newArrayList();
}
