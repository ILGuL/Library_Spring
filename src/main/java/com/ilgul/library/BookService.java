package com.ilgul.library;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookService {
    //This method return concrete book
    public Book get(Long id){
        //TODO get book by od from the DB
        Book testBook = new Book();
        testBook.setName("Eloquent JavaScript, Third Edition");
        testBook.setAuthor("Marijn Haverbeke");
        testBook.setYear(2018);
        return testBook;
    }

    public List<Book> getAll(){
        //TODO get all the books from the DB
        Book testBook = new Book();
        testBook.setName("Eloquent JavaScript, Third Edition");
        testBook.setAuthor("Marijn Haverbeke");
        testBook.setYear(2018);


        Book testBook2 = new Book();
        testBook2.setName("Practical Modern JavaScript");
        testBook2.setAuthor("Nicolás Bevacqua");
        testBook2.setYear(2017);

        return List.of(testBook, testBook2);
    }

    public Book create(Book book){
        //TODO save the book to the DB
        return book;
    }

    public Book update(Long id, Book book){
        //TODO get book by id and update it
        return book;
    }

    public void delete(Long id){
        //TODO delete book by id
    }
}
