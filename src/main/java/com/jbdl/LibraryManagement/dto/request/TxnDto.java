package com.jbdl.LibraryManagement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TxnDto {

    @NotNull(message = "provide userId who is renting it")
    private Integer userId;

    @NotNull(message = "provide bookNo to rent")
    private String bookNo;

}
