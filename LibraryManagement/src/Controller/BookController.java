package controller;

import dao.BookDAO;
import model.Book;
import java.sql.*;
import java.util.List;
import java.util.Random;

public class BookController {

    public boolean addNewBook(Book book) {
        try (Connection conn = util.Javaconnect.connectDb()) {
            BookDAO bookDAO = new BookDAO(conn);
            bookDAO.addBook(book);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateBook(Book book) {
        try (Connection conn = util.Javaconnect.connectDb()) {
            BookDAO bookDAO = new BookDAO(conn);
            bookDAO.updateBook(book);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBook(String bookID) {
        try (Connection conn = util.Javaconnect.connectDb()) {
            BookDAO bookDAO = new BookDAO(conn);
            bookDAO.deleteBook(bookID);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Book getBookById(String id) {
    try (Connection conn = util.Javaconnect.connectDb()) {
        BookDAO bookDAO = new BookDAO(conn);
        return bookDAO.getBookById(id);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


    public List<Book> searchBooks(String searchKey) {
        try (Connection conn = util.Javaconnect.connectDb()) {
            BookDAO bookDAO = new BookDAO(conn);
            return bookDAO.searchBooks(searchKey);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getAllBooks() {
        try (Connection conn = util.Javaconnect.connectDb()) {
            BookDAO bookDAO = new BookDAO(conn);
            return bookDAO.getAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String generateRandomBookID() {
        Random rand = new Random();
        int randomID = rand.nextInt(900000) + 100000;
        return String.valueOf(randomID);
    }
}
