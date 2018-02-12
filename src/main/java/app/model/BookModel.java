package app.model;

import app.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookModel {
    private static BookModel bookModel =new BookModel();
    private List<Book>bookList;
    private BookModel(){
        bookList = new ArrayList<Book>();
    }

    public static BookModel getInstance() {
        return bookModel;
    }

    public List<Book> getBookList(){
        return bookList;
    }


    public void add(Book book){
        bookList.add(book);
    }
}
