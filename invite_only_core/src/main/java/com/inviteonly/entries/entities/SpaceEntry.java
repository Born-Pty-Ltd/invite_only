package com.inviteonly.entries.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inviteonly.docs.entities.IdDocument;
import com.inviteonly.invites.entities.Invite;
import com.inviteonly.spaces.entities.Space;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

@Entity
@Data
public class SpaceEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JsonIgnore
  @ManyToOne
  @NotNull
  private Space space;

  @NotNull
  private LocalDateTime entryDate;

  @OneToOne(cascade = CascadeType.PERSIST)
  @NotNull
  private IdDocument idDocument;

  @NotNull
  private String guardPhone;

  // Only applicable to visitor entries
  @OneToOne
  @JoinColumn
  @Nullable
  private Invite invite;

  @Override
  public String toString() {
    return "SpaceEntry{"
        + "id="
        + id
        + ", spaceId="
        + space.getId()
        + ", entryDate="
        + entryDate
        + ", idDocument="
        + idDocument
        + ", guardPhone='"
        + guardPhone
        + '\''
        + ", inviteId="
        + invite
        + '}';
  }
}
