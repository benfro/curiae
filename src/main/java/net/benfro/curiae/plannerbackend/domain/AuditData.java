package net.benfro.curiae.plannerbackend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.benfro.curiae.plannerbackend.security.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Embeddable
public class AuditData  implements Serializable {
   @CreatedDate
   private LocalDateTime created;
   @CreatedBy
   @ManyToOne
   @JoinColumn(name = "created_by")
   private User createdBy;
   @DateTimeFormat
   private LocalDateTime changed;
   @ManyToOne
   @JoinColumn(name = "changed_by")
   private User changedBy;
}
