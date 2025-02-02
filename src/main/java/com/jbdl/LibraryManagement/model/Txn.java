package com.jbdl.LibraryManagement.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Txn {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;


    @CreationTimestamp
    private Date issueDate;

    private Date expectedReturnDate;
    private Date actualReturnDate;


    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Book book;





}
