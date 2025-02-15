package com.springSecurity.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig{

    @Autowired
    private UserService userService;
    //needed to create user with some authority
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                .username("developer")
                //storing encoded password
                .password("$2a$10$cxAkQxp/tvgkvX93H5gkAe6QheaeiH7kH5xaQqBWlpBABjcJHvT1q")
                .authorities("DEVELOPER","ADMIN")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                //storing encoded password
                .password("$2a$10$zl.r9u6PTo6lt3msW2hoUeWlto35jbp6F0spuPTcrp/VawAnRTQUC")
                .authorities("ADMIN")
                .build();
        return new InMemoryUserDetailsManager();
    }

    //fix this
    @Bean
    UserDetailsManager users(DataSource dataSource) {
//        UserDetails user = User.builder()
//                .username("developer")
//                .password("$2a$10$cxAkQxp/tvgkvX93H5gkAe6QheaeiH7kH5xaQqBWlpBABjcJHvT1q")
//                .authorities("DEVELOPER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("$2a$10$zl.r9u6PTo6lt3msW2hoUeWlto35jbp6F0spuPTcrp/VawAnRTQUC")
//                .authorities("ADMIN")
//                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        users.createUser(admin);
        return users;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                                //anyone can access /home/**
                                .requestMatchers("/home/**").permitAll()
                                //demo can be accessed by admin
                                .requestMatchers("/demo/**").hasAuthority("ADMIN")
                                .requestMatchers("/addAdmin/**").hasAuthority("ADMIN")


                                //demo1 can be accessed by user
                                .requestMatchers("/developer/**").hasAuthority("DEVELOPER")
                               /// tester can be accessed by DEVs,ADMIN
                                .requestMatchers("/tester").hasAnyAuthority("DEVELOPER","ADMIN")
                                .requestMatchers("/admin").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                        //form login is basic login page
                ).formLogin(withDefaults())
                //return response as http response
                //needed for postman
                .httpBasic(withDefaults())
                .csrf(csrf-> csrf.disable());
        return http.build();
    }
    //encode password
    //encode that password -> store it in db
    @Bean
    public PasswordEncoder getEncoder(){
        //no encoding
        //store password as it is
        //developer ->developer
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("developer"));
//        System.out.println(encoder.encode("admin"));
        return encoder;
   //developer -> developer

        //developer -> sdjksdjkdf(encoded password)
     //  return NoOpPasswordEncoder.getInstance();

    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(this.getEncoder());
        return authenticationProvider;
    }

}
