package ru.company.repository.impl;

import ru.company.beans.Book;
import ru.company.beans.Genre;
import ru.company.db.DBUtils;
import ru.company.repository.api.BookRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    @Override
    public List<Book> getAllBook() {
        List<Book> list = new ArrayList();

        try {
            String sql = "SELECT b.name, g.name, a.name\n" +
                         "FROM library.book b\n" +
                         "JOIN library.genre g ON (g.id=b.id_genre)\n" +
                         "JOIN library.author a ON (a.id=b.id_author)";
            ResultSet resultSet = DBUtils.getPreparedStatement(sql).executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setName(resultSet.getString(1));
                book.setGenre(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                list.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Book> getBookById(int id) {
        List<Book> list = new ArrayList<>();

        try {
            String sql = "SELECT b.name, g.name, a.name\n" +
                         "FROM library.book b\n" +
                         "JOIN library.genre g ON (g.id=b.id_genre)\n" +
                         "JOIN library.author a ON (a.id=b.id_author)" +
                         "WHERE g.id=" + id;
            ResultSet resultSet = DBUtils.getPreparedStatement(sql).executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setName(resultSet.getString(1));
                book.setGenre(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                list.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Genre> getAllGenre() {
        List<Genre> genres = new ArrayList<>();

        try {
            String sql = "SELECT g.id, g.name FROM library.genre g";
            ResultSet resultSet = DBUtils.getPreparedStatement(sql).executeQuery();

            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setId(resultSet.getInt(1));
                genre.setName(resultSet.getString(2));
                genres.add(genre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return genres;
    }

}
