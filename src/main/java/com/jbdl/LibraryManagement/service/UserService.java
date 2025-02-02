package com.jbdl.LibraryManagement.service;

import com.jbdl.LibraryManagement.constants.UserType;
import com.jbdl.LibraryManagement.dto.request.UserRequestDto;
import com.jbdl.LibraryManagement.dto.response.UserResponseDto;
import com.jbdl.LibraryManagement.model.User;
import com.jbdl.LibraryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //constructor injection

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = User.builder().email(userRequestDto.getEmail()).phoneNumber(userRequestDto.getPhoneNumber())
                .name(userRequestDto.getName()).build();
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
}
//update
//delete
//filter

