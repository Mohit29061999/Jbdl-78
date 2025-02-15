package com.jbdl.LibraryManagement.repository;

import com.jbdl.LibraryManagement.model.Txn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxnRepository extends JpaRepository<Txn,String> {
}
