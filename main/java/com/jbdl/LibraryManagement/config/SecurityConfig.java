package com.jbdl.LibraryManagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Value("${user.authority.student}")
    private String studentAuthority;


    @Value("${user.authority.admin}")
    private String adminAuthority;




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //if using authroities, use authorities here too
        http
                .authorizeHttpRequests(authorize -> authorize
                                //anyone can home
                                .requestMatchers("/user/filter/**").hasAnyAuthority(studentAuthority, adminAuthority)
                                .requestMatchers("/user/student/**").permitAll()

                                //demo can be accessed by admin
                                .requestMatchers("/user/addAdmin/**").permitAll()




                                //demo1 can be accessed by user

                                .requestMatchers("/txn/**").hasAnyAuthority(adminAuthority)
                                .requestMatchers("/book/filter/**").hasAnyAuthority(studentAuthority, adminAuthority)
                                .requestMatchers("/book/**").hasAuthority(adminAuthority)
                                .anyRequest().authenticated()
                        //form login is basic login page
                ).formLogin(withDefaults())
                //return response as http response
                //needed for postman
                .httpBasic(withDefaults())
                //it will not match csrf
                .csrf(csrf -> csrf.disable())
        ;
        return http.build();
    }


    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}

