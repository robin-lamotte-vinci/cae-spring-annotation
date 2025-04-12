package be.vinci.ipl.annotation.models.dtos;

import be.vinci.ipl.annotation.models.entities.User.Types;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * NewUser DTO.
 */
@Data
@NoArgsConstructor
public class NewUser {

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  @NotBlank
  private String creatorUsername;

  @NotNull
  private Types type;
}