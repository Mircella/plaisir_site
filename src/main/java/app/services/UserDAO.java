package app.services;

import app.entities.Book;
import app.entities.User;

import java.sql.SQLException;
import java.util.List;

interface UserDAO {
    User saveUser(User user) throws SQLException;
    int updateUser(int id, User user) throws SQLException;

    void deleteUser(User user) throws SQLException;

    User getUserById(int id) throws SQLException;
    User getUserByName(String name) throws SQLException;

    List<User> getAllUsers() throws SQLException;
    List<User> getUsersByBook(Book book)throws SQLException;
}
