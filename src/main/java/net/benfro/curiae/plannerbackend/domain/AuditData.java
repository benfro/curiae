package net.benfro.curiae.plannerbackend.domain;

import lombok.Data;
import net.benfro.curiae.plannerbackend.security.User;

import java.time.LocalDateTime;

@Data
public class AuditData {
   private LocalDateTime created;
   private User createdBy;
   private LocalDateTime changed;
   private User changedBy;
}
