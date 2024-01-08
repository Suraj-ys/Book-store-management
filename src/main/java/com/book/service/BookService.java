package com.book.service;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public Book createBook(Book book) {

        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setBookId(id);
            return bookRepository.save(book);
        }
        return null; // Book not found
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

