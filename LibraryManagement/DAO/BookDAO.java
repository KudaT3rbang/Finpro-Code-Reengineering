package dao;

import model.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private Connection conn;

    public BookDAO(Connection conn) {
        this.conn = conn;
    }

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO Book (ID, title, writer, pageCount) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, book.getId());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getWriter());
            pst.setInt(4, book.getPageCount());
            pst.executeUpdate();
        }
    }

    public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE Book SET title = ?, writer = ?, pageCount = ? WHERE ID = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, book.getTitle());
            pst.setString(2, book.getWriter());
            pst.setInt(3, book.getPageCount());
            pst.setString(4, book.getId());
            pst.executeUpdate();
        }
    }

    public void deleteBook(String bookID) throws SQLException {
        String sql = "DELETE FROM Book WHERE ID = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, bookID);
            pst.executeUpdate();
        }
    }

    public Book getBookById(String id) throws SQLException {
        String sql = "SELECT * FROM Book WHERE ID = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return new Book(
                            rs.getString("ID"),
                            rs.getString("title"),
                            rs.getString("writer"),
                            rs.getInt("pageCount")
                    );
                }
            }
        }
        return null;
    }

    public List<Book> searchBooks(String searchKey) throws SQLException {
        String sql = "SELECT * FROM Book WHERE title LIKE ? OR writer LIKE ?";
        List<Book> books = new ArrayList<>();

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, "%" + searchKey + "%");
            pst.setString(2, "%" + searchKey + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                books.add(new Book(rs.getString("ID"), rs.getString("title"), rs.getString("writer"), rs.getInt("pageCount")));
            }
        }
        return books;
    }

    public List<Book> getAllBooks() throws SQLException {
        String sql = "SELECT * FROM Book";
        List<Book> books = new ArrayList<>();

        try (PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                books.add(new Book(
                        rs.getString("ID"),
                        rs.getString("title"),
                        rs.getString("writer"),
                        rs.getInt("pageCount")
                ));
            }
        }
        return books;
    }

}
