package com.azure.key.vault.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azure.key.vault.main.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
