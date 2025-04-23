package library;

public class Book {
    String bookName;
    String authorName;
    String genre;
    boolean available;
    public Book(String bookName, String authorName, String genre) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
        this.available = true;
    }
    public void updateBook(String bookName, String authorName, String genre) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
    }
    @Override
    public String toString() {
        return "BookName=" + bookName + ", AuthorName=" + authorName + ", Genre=" + genre + "\tAvailablity = "+
        ((available)?"Available":"Not Available");
    }
    
}
