package com.raf.si.Banka2Backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(
    name = "permissions",
    uniqueConstraints = {@UniqueConstraint(columnNames = "permissionName")})
public class Permission {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull private PermissionName permissionName;

  @ManyToMany(mappedBy = "permissions")
  @JsonIgnore
  private Collection<User> users;

  public Permission(PermissionName permissionName) {
    this.permissionName = permissionName;
  }
}
