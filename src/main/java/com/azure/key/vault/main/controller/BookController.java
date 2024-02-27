package com.azure.key.vault.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import com.azure.key.vault.main.entity.Book;
import com.azure.key.vault.main.repository.BookRepository;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
	
	@Autowired
	BookRepository bookRepository;

	@Value("${spring.datasource.username}")
	private String dbusername;
	
	@Value("${spring.datasource.password}")
	private String dbpassword;
	
    @GetMapping(value="/all")
    public  ResponseEntity<List<Book>> getBooks() {

			System.out.println("-------- spring.datasource.username : "+dbusername);
		System.out.println("-------- spring.datasource.password :  "+dbpassword);
	    
        List<Book> bookList = bookRepository.findAll();
        return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
    }

}
