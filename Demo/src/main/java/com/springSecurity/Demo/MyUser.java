package com.springSecurity.Demo;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String username;
    private String name;
    private String password;
    private boolean accountExpired;
    private boolean accountNonLocked;

    //Mohit -> DEVELOPER, TESTER, ADMIN
    private String authorities; //developer,tester
    //DEVELOPER tester





    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(authorities.split(","))
                .map(authorities -> new SimpleGrantedAuthority(authorities)).
                collect(Collectors.toList());
//        return Arrays.stream(authorities.split(",")).map(
//                a-> new SimpleGrantedAuthority(a)
//        ).collect(Collectors.toList());
    }


    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return !accountExpired;
    }


    @Override
    public boolean isAccountNonLocked() {
        return !accountNonLocked;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }


    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
