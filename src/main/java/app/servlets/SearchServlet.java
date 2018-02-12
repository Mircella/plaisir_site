package app.servlets;

import app.HibernateUtil;
import app.entities.Book;
import app.entities.BookCategory;
import app.model.BookModel;
import app.services.Factory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = -4914856137989997740L;

    public SearchServlet() {
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init() of SearchServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/search_result.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        List<Book> bookList=null;
        try {
            bookList = Factory.getFactory().getBookService().getAllBooks();
        }catch (Exception e){
            e.printStackTrace();
        }
        Book result=null;
        for(Book book:bookList){
            if(book.getTitle().contains(search)){
                result=book;
                break;
            }else {
                result = new Book("No title","No description", 0, new BookCategory("no category"));
            }
        }

        req.setAttribute("book",result);

        doGet(req,resp);
    }
}
