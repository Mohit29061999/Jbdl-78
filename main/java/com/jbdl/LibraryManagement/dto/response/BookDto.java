package com.jbdl.LibraryManagement.dto.response;

import com.jbdl.LibraryManagement.constants.BookType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private String title;

    @NotBlank(message = "bookNo can't be blank")
    private String bookNo;


    @Positive
    private Double securityAmount;

    private BookType bookType;

//    private String authorEmail;
//    private String authorName;
}
