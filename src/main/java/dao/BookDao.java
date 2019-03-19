package dao;

import model.Book;

import java.util.List;

public interface BookDao {

    List<Book> findAll();

    Book getBookById(String id);

    boolean insertBook(Book book);

    boolean deleteBook(String id);
}
