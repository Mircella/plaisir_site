package app.servlets;

import app.entities.Book;
import app.entities.BookCategory;
import app.entities.User;
import app.services.Factory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ForumServlet extends HttpServlet {
    private static final long serialVersionUID = -7545660300076778733L;

    public ForumServlet() {

    }

    @Override
    public void init() throws ServletException {
        int forumParameter = Integer.parseInt(getServletConfig().getInitParameter("paramFirst"));
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String genParameter = config.getInitParameter("generalParamFirst");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = null;
        try {
            userList = Factory.getFactory().getUserService().getAllUsers();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/forum.jsp");
        req.setAttribute("users",userList);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
