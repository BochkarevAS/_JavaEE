package ru.company.service.api;

import ru.company.beans.Book;
import ru.company.beans.Genre;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();

    List<Book> getBookById(int id);

    List<Genre> getAllGenre();

}
