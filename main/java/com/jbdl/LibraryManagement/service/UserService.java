package com.jbdl.LibraryManagement.service;

import com.jbdl.LibraryManagement.constants.UserType;
import com.jbdl.LibraryManagement.dto.request.UserRequestDto;
import com.jbdl.LibraryManagement.dto.response.UserResponseDto;
import com.jbdl.LibraryManagement.model.User;
import com.jbdl.LibraryManagement.repository.CahceRepository;
import com.jbdl.LibraryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Value("${user.authority.student}")
    private String studentAuthority;


    @Value("${user.authority.admin}")
    private String adminAuthority;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CahceRepository cahceRepository;



    //constructor injection

    public UserResponseDto createStudent(UserRequestDto userRequestDto) {
        User user = User.builder().email(userRequestDto.getEmail()).phoneNumber(userRequestDto.getPhoneNumber())
                .name(userRequestDto.getName())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .authority(studentAuthority)
                .build();
        user.setUserType(UserType.STUDENT);
        user = userRepository.save(user);

        UserResponseDto userResponseDto  = UserResponseDto.builder().
                name(user.getName()).email(user.getEmail()).phoneNumber(user.getPhoneNumber())
                .build();
        return userResponseDto;
    }

    public UserResponseDto createAdmin(UserRequestDto userRequestDto) {
        User user = User.builder().email(userRequestDto.getEmail()).phoneNumber(userRequestDto.getPhoneNumber())
                .name(userRequestDto.getName())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .authority(adminAuthority)
                .build();
        user.setUserType(UserType.STUDENT);
        user = userRepository.save(user);

        UserResponseDto userResponseDto  = UserResponseDto.builder().
                name(user.getName()).email(user.getEmail()).phoneNumber(user.getPhoneNumber())
                .build();
        return userResponseDto;
    }


    public User isUserValid(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent())
            return user.get();

        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //find user by email???
        //check for user in redis first
        //if exists then return from redis
        User user = cahceRepository.getUser(email);
        if(user!=null)
            return user;

        //call db
        user =  userRepository.findByEmail(email);
       if(user == null){
           throw new UsernameNotFoundException("user with email :"+ email + " doesn't exist");
       }
        cahceRepository.setUser(email,user);
       return user;
    }
}
//update
//delete
//filter

