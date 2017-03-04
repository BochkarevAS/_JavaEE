package ru.company.repository.api;

import ru.company.beans.Book;
import ru.company.beans.Genre;

import java.util.List;

public interface BookRepository {

    List<Book> getAllBook();

    List<Book> getBookById(int id);

    List<Genre> getAllGenre();

}
