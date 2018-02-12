package app.services;

import app.HibernateUtil;
import app.entities.BookCategory;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class BookCategoryService implements BookCategoryDAO {
    @Override
    public BookCategory saveBookCategory(BookCategory bookCategory) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            bookCategory = (BookCategory) session.save(bookCategory);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return bookCategory;
    }

    @Override
    public long updateBookCategory(long id, BookCategory bookCategory) throws SQLException {
        Session session = null;
        long resultId=0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(bookCategory);
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
    public void deleteBookCategory(BookCategory bookCategory) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(bookCategory);
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
    public BookCategory getBookCategoryById(long id) throws SQLException {
        BookCategory bookCategory=null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            bookCategory = (BookCategory) session.load(BookCategory.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            bookCategory = null;
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return bookCategory;
    }

    @Override
    public BookCategory getBookCategoryByTitle(String title) throws SQLException {
        BookCategory bookCategory = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT * FROM `book_category` WHERE `title` LIKE \"%"+title+"%\"");
            query.addEntity(BookCategory.class);
            bookCategory = (BookCategory)query.uniqueResult();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return bookCategory;
    }

    @Override
    public List<BookCategory> getAllBookCategories() throws SQLException {
        List<BookCategory> bookCategories = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT * FROM `book_category`");
            query.addEntity(BookCategory.class);
            bookCategories = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return bookCategories;
    }
}
