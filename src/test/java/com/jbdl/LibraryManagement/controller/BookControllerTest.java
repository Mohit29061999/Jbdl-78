package com.jbdl.LibraryManagement.controller;

import com.jbdl.LibraryManagement.constants.BookType;
import com.jbdl.LibraryManagement.dto.response.BookDto;
import com.jbdl.LibraryManagement.service.BookService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void createBookWithCorrectValues() throws Exception {
        JSONObject bookDto = new JSONObject();
        bookDto.put("title","book1");
        bookDto.put("bookNo","book1");
        bookDto.put("securityAmount",60.0);

       com.jbdl.LibraryManagement.dto.response.BookDto responseDto = com.jbdl.LibraryManagement.dto.response.BookDto
                       .builder().bookNo("book1").securityAmount(60.0).build();

         when(bookService.createBook(any())).thenReturn(responseDto);

        mockMvc.perform(post("/book").contentType("application/json")
                .content(bookDto.toString())).andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    public void createBookWithNoBookNo() throws Exception {
        JSONObject bookDto = new JSONObject();
        bookDto.put("title","book1");
       // bookDto.put("bookNo","book1");
        bookDto.put("securityAmount",60.0);

        com.jbdl.LibraryManagement.dto.response.BookDto responseDto = com.jbdl.LibraryManagement.dto.response.BookDto
                .builder().bookNo("book1").securityAmount(60.0).build();

        when(bookService.createBook(any())).thenReturn(responseDto);

        mockMvc.perform(post("/book").contentType("application/json")
                .content(bookDto.toString())).andExpect(MockMvcResultMatchers.status().isBadRequest());


    }

}
