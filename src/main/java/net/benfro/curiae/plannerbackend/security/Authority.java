package net.benfro.curiae.plannerbackend.security;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Authority implements GrantedAuthority, Serializable {

   public enum Type {
      CAN_CREATE_USER("CAN_CREATE_USER"),
      CAN_EDIT_USER("CAN_EDIT_USER"),
      CAN_DELETE_USER("CAN_DELETE_USER"),
      CAN_CREATE_AUTHOR("CAN_CREATE_AUTHOR"),
      CAN_EDIT_AUTHOR("CAN_EDIT_AUTHOR"),
      CAN_DELETE_AUTHOR("CAN_DELETE_AUTHOR"),
      CAN_CREATE_ITEM("CAN_CREATE_ITEM"),
      CAN_EDIT_ITEM("CAN_EDIT_ITEM"),
      CAN_DELETE_ITEM("CAN_DELETE_ITEM"),
      ;

      private final String authority;

      Type(String authority) {
         this.authority = authority;
      }

      String getAuthority() {
         return authority;
      }
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Enumerated(EnumType.STRING)
   private Type type;
   @ManyToMany(mappedBy ="authorities")
   private List<Role> authorizedRoles = Lists.newArrayList();

   @Override
   public String getAuthority() {
      return type.getAuthority();
   }

}
