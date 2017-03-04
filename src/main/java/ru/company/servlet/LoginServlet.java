package ru.company.servlet;

import ru.company.beans.Book;
import ru.company.beans.Genre;
import ru.company.beans.Letters;
import ru.company.beans.LoginForm;
import ru.company.service.api.BookService;
import ru.company.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("utf-8");

        String nick = request.getParameter("nick");
        String login = request.getParameter("login");

        LoginForm user = new LoginForm();
        user.setNick(nick);
        user.setLogin(login);

        session.setAttribute("user", user);

        if (true) {
            List<Book> allBook = bookService.getAllBook();
            request.setAttribute("allBook", allBook);

            List<Genre> allGenre = bookService.getAllGenre();
            request.setAttribute("allGenre", allGenre);

            Letters letters = new Letters();
            request.setAttribute("letter", letters.getLetter());

            request.getRequestDispatcher("view/book.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
