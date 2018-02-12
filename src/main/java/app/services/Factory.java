package app.services;

public class Factory {
    private static BookService bookService = null;
    private static BookCategoryService bookCategoryService=null;
    private static UserService userService = null;
    private static Factory factory = null;

    public static synchronized Factory getFactory(){
        if (factory == null) {
            factory = new Factory();
        }
        return factory;
    }
    public BookCategoryService getBookCategoryService(){
        if (bookCategoryService == null) {
            bookCategoryService = new BookCategoryService();
        }
        return bookCategoryService;
    }

    public BookService getBookService() {
        if (bookService == null) {
            bookService = new BookService();
        }
        return bookService;
    }

    public UserService getUserService(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }
}
