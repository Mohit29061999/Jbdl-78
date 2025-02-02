package com.jbdl.LibraryManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jbdl.LibraryManagement.constants.BookType;
import com.sun.jdi.BooleanType;
import jakarta.persistence.*;
import jakarta.transaction.Transaction;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    private String title;

    @Column(unique = true,nullable = false)
    private String bookNo;


    @Positive
    private Double securityAmount;

    @Enumerated(value = EnumType.STRING)
    private BookType bookType;


    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name ="author_name",referencedColumnName="name"),
            @JoinColumn(name ="author_email",referencedColumnName="email"),

    })
//    @JsonIgnore
    @JsonIgnoreProperties(value = "books")
    //it is combo of two things -> email and name
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Txn> txns;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public Double getSecurityAmount() {
        return securityAmount;
    }

    public void setSecurityAmount(Double securityAmount) {
        this.securityAmount = securityAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Txn> getTxns() {
        return txns;
    }

    public void setTxns(List<Txn> txns) {
        this.txns = txns;
    }
}

/**
 *
 * one book can be taken by one user
 * one user can take many book
 *
 *
 * an author can write mutiple books but one book will be written by a single author
 */
