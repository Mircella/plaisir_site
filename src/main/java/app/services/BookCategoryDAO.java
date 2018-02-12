package app.services;

import app.entities.Book;
import app.entities.BookCategory;

import java.sql.SQLException;
import java.util.List;

interface BookCategoryDAO {
    BookCategory saveBookCategory(BookCategory bookCategory) throws SQLException;
    long updateBookCategory(long id, BookCategory bookCategory) throws SQLException;

    void deleteBookCategory(BookCategory bookCategory) throws SQLException;

    BookCategory getBookCategoryById(long id) throws SQLException;
    BookCategory getBookCategoryByTitle(String title) throws SQLException;

    List<BookCategory> getAllBookCategories() throws SQLException;
}
