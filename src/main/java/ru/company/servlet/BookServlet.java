package ru.company.servlet;

import ru.company.beans.Book;
import ru.company.beans.Genre;
import ru.company.service.api.BookService;
import ru.company.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        List<Book> allBook = bookService.getBookById(id);
        request.setAttribute("allBook", allBook);

        List<Genre> allGenre = bookService.getAllGenre();
        request.setAttribute("allGenre", allGenre);

        request.getRequestDispatcher("view/book.jsp").forward(request, response);
    }
}
