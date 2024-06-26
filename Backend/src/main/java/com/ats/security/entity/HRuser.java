package com.ats.security.entity;



import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hruser")
public class HRuser implements UserDetails{
  @Id
  @GeneratedValue
  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private int contactNo;
  private String address;
  private String JobPosition;
  private String password;
  @Enumerated(EnumType.STRING)
  private Role role;
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	return role.getAuthorities();
}
@Override
public String getUsername() {
    return email;
}

@Override
public String getPassword() {
    return password;
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
