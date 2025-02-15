package com.jbdl.LibraryManagement.controller;

import com.jbdl.LibraryManagement.constants.UserFilterType;
import com.jbdl.LibraryManagement.constants.Operator;
import com.jbdl.LibraryManagement.dto.request.UserRequestDto;
import com.jbdl.LibraryManagement.dto.response.UserResponseDto;
import com.jbdl.LibraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/student")
    public UserResponseDto createStudent(@RequestBody @Validated UserRequestDto userRequestDto){
        return userService.createStudent(userRequestDto);
    }

    @PostMapping("/addAdmin")
    public UserResponseDto createAdmin(@RequestBody @Validated UserRequestDto userRequestDto){
        return userService.createAdmin(userRequestDto);
    }



    @GetMapping("/filter")
    public List<UserResponseDto> getUsers(@RequestParam("filterBy") UserFilterType filterType,
                                          @RequestParam("operator")Operator operator,@RequestParam("value") String value){
        return null;
    }

}

/***
 * CRUD
 * create -> user
 * filter -> list of user applying some filter
 * update->  complete it
 * delete -> complete it
 */
