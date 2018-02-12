package app.services;

import app.entities.Book;
import app.entities.BookCategory;
import app.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {

    Book saveBook(Book book) throws SQLException;
    long updateBook(long id, Book book) throws SQLException;

    void deleteBook(Book book) throws SQLException;

    Book getBookById(long id) throws SQLException;
    Book getBookByTitle(String title) throws SQLException;

    List<Book> getAllBooks() throws SQLException;
    List<Book> getBooksByCategory(BookCategory bookCategory)throws SQLException;
    List<Book> getBooksByUser(User user)throws SQLException;
}
