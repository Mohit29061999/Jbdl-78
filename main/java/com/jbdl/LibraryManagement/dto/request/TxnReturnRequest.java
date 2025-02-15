package com.jbdl.LibraryManagement.dto.request;

import com.jbdl.LibraryManagement.model.Book;
import com.jbdl.LibraryManagement.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TxnReturnRequest {

    @NotNull(message = "userId shouldn't be null")
    private Integer userId;

    @NotNull(message = "bookId shouldn't be null")
    private String bookNo;

    @NotNull(message = "txnId shouldn't be null")
    private String txnId;

}
