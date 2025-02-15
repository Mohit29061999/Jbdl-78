package com.jbdl.LibraryManagement.dto.request;

import com.jbdl.LibraryManagement.constants.BookType;
import com.jbdl.LibraryManagement.model.Author;
import com.jbdl.LibraryManagement.model.Book;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

//a class has custom code/code that you are will have to test it
public class BookDto {
    @NotBlank(message = "title can't be blank")
    private String title;

    @NotBlank(message = "bookNo can't be blank")
    private String bookNo;


    @Positive
    private Double securityAmount;

    private BookType bookType;

    private String authorEmail;
    private String authorName;

    public Book createBook(){
        Author author = Author.builder().email(authorEmail).name(authorName).build();
       return  Book.builder().title(title).bookNo(bookNo).bookType(bookType).author(author)
               .securityAmount(securityAmount)
               .build();

    }



}

//update
//delete
