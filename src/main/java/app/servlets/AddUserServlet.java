package app.servlets;

import app.HibernateUtil;
import app.entities.Status;
import app.entities.User;
import app.entities.UserModel;
import app.services.Factory;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = -8700177466417097829L;

    public AddUserServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/add_user.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        User user2 = null;
        if(password.equals(password2)&&checkMail(email)){
            User user = new User(login,email,password,new Status(1));
            try {
                user2 = Factory.getFactory().getUserService().saveUser(user);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{

        }
        req.setAttribute("savedUser",user2);
        doGet(req,resp);
    }

    private boolean checkMail(String email){
        boolean check = false;
        int index1 = email.indexOf("@");
        if(index1>0){
            if(email.indexOf(".",index1)>0){
                check=true;
            }
        }
        return check;
    }
}
