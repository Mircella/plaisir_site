package app.servlets;

import app.entities.Book;
import app.entities.User;
import app.services.Factory;
import org.hibernate.ObjectNotFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUserServlet extends HttpServlet {
    private static final long serialVersionUID = -1837607577017707413L;

    public GetUserServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/get_user.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = null;
        List<Book> bookList = null;
        try {
            user = Factory.getFactory().getUserService().getUserByName(login);
            if(user.getPassword().equals(password)){
                req.setAttribute("user",user);
                try {
                    bookList = Factory.getFactory().getBookService().getBooksByUser(user);
                    req.setAttribute("bookList",bookList);
                }catch (Exception e){}
            }else{
                user = new User(login,null);
                req.setAttribute("user",user);
                }
        }catch (ObjectNotFoundException e){
            user = new User(null,null);
            req.setAttribute("user",user);
        }
        catch (Exception e){e.printStackTrace();
        }

        doGet(req,resp);
    }
}
