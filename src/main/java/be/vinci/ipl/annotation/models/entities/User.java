package be.vinci.ipl.annotation.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * User entity.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_user")
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  @JsonIgnore
  private String password;

  // This entity is a hierarchical cyclic table,
  // only the very first user has a null field for creator
  @ManyToOne
  @JoinColumn(name = "creator")
  @JsonIgnore
  private User creator;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Types type;

  /**
   * Enum representing the types of users.
   */
  public enum Types {
    USER,
    ADMIN
  }
}
