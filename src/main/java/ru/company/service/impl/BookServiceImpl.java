package ru.company.service.impl;

import ru.company.beans.Book;
import ru.company.beans.Genre;
import ru.company.repository.api.BookRepository;
import ru.company.repository.impl.BookRepositoryImpl;
import ru.company.service.api.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }

    @Override
    public List<Book> getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public List<Genre> getAllGenre() {
        return bookRepository.getAllGenre();
    }
}
