package net.benfro.curiae.plannerbackend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.benfro.curiae.plannerbackend.security.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Embeddable
public class AuditData  implements Serializable {
   @Temporal(value = TemporalType.TIMESTAMP)
   private LocalDateTime created;
   @ManyToOne
   @JoinColumn(name = "createdBy_id")
   private User createdBy;
   @Temporal(value = TemporalType.TIMESTAMP)
   private LocalDateTime changed;
   @ManyToOne
   @JoinColumn(name = "changedBy_id")
   private User changedBy;
}
