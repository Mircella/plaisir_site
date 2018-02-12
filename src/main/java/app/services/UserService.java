package app.services;

import app.HibernateUtil;
import app.entities.Book;
import app.entities.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class UserService implements UserDAO {
    @Override
    public User saveUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //user = (User) session.save(user);
            SQLQuery query = session.createSQLQuery("INSERT INTO `users` (" +
                    "`email`," +
                    "`login`," +
                    "`password`," +
                    "`status_id`) VALUES(" +
                    "\""+user.getEmail()+"\"," +
                    "\""+user.getLogin()+"\"," +
                    "\""+user.getPassword()+"\"," +
                    "1);");
            query.addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return user;
    }

    @Override
    public int updateUser(int id, User user) throws SQLException {
        Session session = null;
        int resultId=0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            resultId = id;
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return resultId;
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public User getUserById(int id) throws SQLException {
        User user=null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            user = (User) session.load(User.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            user = null;
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return user;
    }

    @Override
    public User getUserByName(String name) throws SQLException {
        User user = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT * FROM `users` WHERE `login` LIKE \"%"+name+"%\"");
            query.addEntity(User.class);
            user = (User) query.uniqueResult();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> userList = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT * FROM `users`");
            query.addEntity(User.class);
            userList = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return userList;
    }

    @Override
    public List<User> getUsersByBook(Book book) throws SQLException {
        Session session = null;
        List<User> userList = null;
        long book_id=book.getId();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT * FROM `users` INNER JOIN `users_books`" +
                    "ON `users`.`id`=`users_books`.`user_id` WHERE `book_id`="+book_id);
            query.addEntity(User.class);
            userList = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return userList;
    }
}
