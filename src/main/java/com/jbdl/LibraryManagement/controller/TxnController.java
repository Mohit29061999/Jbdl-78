package com.jbdl.LibraryManagement.controller;

import com.jbdl.LibraryManagement.dto.request.TxnDto;
import com.jbdl.LibraryManagement.dto.request.TxnReturnRequest;
import com.jbdl.LibraryManagement.exception.BookException;
import com.jbdl.LibraryManagement.exception.UserException;
import com.jbdl.LibraryManagement.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    TxnService txnService;

    @PostMapping
    public String createTxn(@RequestBody TxnDto txnDto) throws UserException {

        return txnService.createTxn(txnDto);
    }

    //returnBook
    //when we want to update an data
    @PutMapping("/returnBook")
    public ResponseEntity<String> returnBook(@RequestBody @Validated TxnReturnRequest txnReturnRequest) throws UserException,
            BookException {
         String id = txnService.returnBook(txnReturnRequest);
         if(id==null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
