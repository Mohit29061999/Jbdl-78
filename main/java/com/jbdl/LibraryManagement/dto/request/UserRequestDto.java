package com.jbdl.LibraryManagement.dto.request;

import com.jbdl.LibraryManagement.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "email can't be blank")
    private String email;

    @NotNull
    private String phoneNumber;

    @NotBlank(message = "name can't be blank")
    private String name;

    @NotBlank(message = "password can't be blank")
    private String password;

}
