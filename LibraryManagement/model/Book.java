package model;

public class Book {
    private String id;
    private String title;
    private String writer;
    private int pageCount;

    // Constructor
    public Book(String id, String title, String writer, int pageCount) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.pageCount = pageCount;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
