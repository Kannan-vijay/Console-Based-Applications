package library;

import java.util.ArrayList;

public class User {
    String userName;
    int borrowBookCount;
    ArrayList<Book> borrowedBookes;
    public User(String userName) {
        this.userName = userName;
        this.borrowBookCount = 0;
        this.borrowedBookes = new ArrayList<>();
    }
    public void borrowBook(Book book){
        if(borrowBookCount>= 5){
            System.out.println("You have already borrowed "+borrowBookCount+" books");
            return;
        }
        borrowedBookes.add(book);
        borrowBookCount++;
        System.out.println("Book borrowed sucessfully..");
    }
    public void returnBook(Book book){
        if(!borrowedBookes.contains(book)){
            System.out.println("You dont have that Book to return..");
            return;
        }
        borrowedBookes.remove(book);
        borrowBookCount--;
        System.out.println("Book was Return Sucessfully..");
    }
    public void displayBorrowedBooks(){
        System.out.println("Book Name\tAuthor\tGenre");
        for (Book book : borrowedBookes) {
            System.out.println(book.bookName+"\t\t"+book.authorName+"\t"+book.genre);
        }
    }
    @Override
    public String toString() {
        return  userName + "\t" + borrowBookCount;
    }
    
}
