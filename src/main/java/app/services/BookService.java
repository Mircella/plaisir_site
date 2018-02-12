package app.services;

import app.HibernateUtil;
import app.entities.Book;
import app.entities.BookCategory;
import app.entities.User;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class BookService implements BookDAO {
    @Override
    public Book saveBook(Book book) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            book = (Book) session.save(book);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return book;
    }

    @Override
    public long updateBook(long id, Book book) throws SQLException {
        Session session = null;
        long resultId=0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(book);
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
    public void deleteBook(Book book) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(book);
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
    public Book getBookById(long id) throws SQLException {
        Book book=null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            book = (Book)session.load(Book.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            book = null;
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return book;
    }

    @Override
    public Book getBookByTitle(String title) throws SQLException {
        Book book = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT * FROM `books` WHERE `title` LIKE \"%"+title+"%\"");
            query.addEntity(Book.class);
            book = (Book)query.uniqueResult();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() throws SQLException {
        List<Book> bookList = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT * FROM `books`");
            query.addEntity(Book.class);
            bookList = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return bookList;
    }

    @Override
    public List<Book> getBooksByCategory(BookCategory bookCategory) throws SQLException {
        Session session = null;
        List<Book> bookList = null;
        long cat_id = bookCategory.getId();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT * FROM `books` WHERE `category_id` = "+cat_id);
            query.addEntity(Book.class);
            bookList = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return bookList;
    }

    @Override
    public List<Book> getBooksByUser(User user) throws SQLException {
        Session session = null;
        List<Book> bookList = null;
        long user_id=user.getId();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT * FROM `books` INNER JOIN `users_books`" +
                    "ON `books`.`id`=`users_books`.`book_id` WHERE `user_id`="+user_id);
            query.addEntity(Book.class);
            bookList = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return bookList;
    }
}
