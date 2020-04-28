package net.benfro.curiae.plannerbackend.security;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.benfro.curiae.plannerbackend.domain.AuditData;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails, Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @NotNull
   private String username;
   @NotNull
   private String password;
   private String email;
   private AuditData audit;
   //private boolean enabled;
   //private boolean credentialsNonExpired;
   //private boolean accountNonExpired;
   //private boolean accountNonLocked;
   @ManyToMany
   @JoinTable(name="USER_ROLE")
   private List<Role> roles = Lists.newArrayList();

   public User(String username, String password) {
      this.username = username;
      this.password = password;
      audit = new AuditData();
   }



   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return roles.stream().flatMap(r -> r.getAuthorities().stream()).collect(Collectors.toList());
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }
}
