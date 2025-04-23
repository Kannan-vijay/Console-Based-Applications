package library;

import java.util.*;

public class LibraryHandler {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    public void addBook(Scanner sc){
        System.out.println("Enter the Name of the Book :");
        String bookName = sc.nextLine();
        System.out.println("Enter the Author Name of the Book :");
        String authorName = sc.nextLine();
        System.out.println("Enter the Genre of the Book :");
        String genre = sc.nextLine();
        Book newbBook = new Book(bookName, authorName, genre);
        books.add(newbBook);
        System.out.println("Book was Added SucessFully..");
    }
    public void updateBook(Scanner sc){
        System.out.println("Enter the Name of the Book to upadate :");
        String bookName = sc.nextLine();
        Book selectedBook = null;
        for (Book book : books) {
            if(book.bookName.equals(bookName)){
                selectedBook = book;
                break;
            }
        }
        if(selectedBook == null){
            System.out.println("There is No Book in this Name..");
            return;
        }
        System.out.println("Enter the Author Name to update :");
        String authorName = sc.nextLine();
        System.out.println("Enter the Genre to Update :");
        String genre = sc.nextLine();
        selectedBook.updateBook(bookName, authorName, genre);
        System.out.println("Book Updated Sucessfully..");
        System.out.println(selectedBook);
    }
    public void removeBook(Scanner sc){
        System.out.println("Enter the Name of the book to Remove: ");
        String bookName = sc.nextLine();
        Book selectedBook = null;
        for (Book book : books) {
            if(book.bookName.equals(bookName)){
                selectedBook = book;
                break;
            }
        }
        if(selectedBook == null){
            System.out.println("There is No Book available in this Name..");
            return;
        }
        books.remove(selectedBook);
        System.out.println("Book Removed Sucessfully..");
    }
    public User checkMember(String name){
        for (User user : users) {
            if(user.userName.equals(name)){
                return user;
            }
        }
        return addMember(name);
    }
    public User addMember(String name){
        User newuUser = new User(name);
        users.add(newuUser);
        return newuUser;
    }
    public void addMember(Scanner sc){
        System.out.println("Enter the Name of the User or Member :");
        String name = sc.nextLine();
        User newuUser = new User(name);
        users.add(newuUser);
        System.out.println("New Member was Added Sucessfully..");
    }
    public void displayAllBooks(){
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public void displayAllMembers(){
        System.out.println("Name\tBoorwed Book Count");
        for (User user : users) {
            System.out.println(user);
        }
    }
    public void borrowBook(User user,Scanner sc){
        System.out.println("Enter the Book Name to Borrow :");
        String bookName = sc.nextLine();
        Book selectedbook = null;
        for (Book book : books) {
            if(book.bookName.equals(bookName)){
                if (!book.available) {
                    System.out.println("Book is Not Available..");
                    return;
                }
                selectedbook = book;
            }
        }
        if(selectedbook == null){
            System.out.println("There is No Book in this Name :"+bookName);
        }
        user.borrowBook(selectedbook);
        selectedbook.available = false;
    }
    public void returnBook(User user,Scanner sc){
        System.out.println("Enter the Name of the Book return :");
        String bookName = sc.nextLine();
        Book selectedBook = null;
        for (Book book : books) {
            if(book.bookName.equals(bookName)){
                selectedBook = book;
            }
        }
        if(selectedBook == null){
            System.out.println("This Book is Not Ours..");
            return;
        }
        user.returnBook(selectedBook);
        selectedBook.available = true;
    }
    public void seeBorrowedBooks(User user){
        System.out.println("Borrowed Book Count :"+user.borrowBookCount);
        user.displayBorrowedBooks();
    }
    public void displayBookByName(Scanner sc){
        System.out.println("Enter the Book Name");
        String bookname = sc.nextLine();
        int count = 0;
        for (Book book : books) {
            if(book.bookName.equals(bookname)){
                System.out.println(book);
                count++;
            }
        }
        if(count == 0){
            System.out.println("There is No Book Available in this Name..");
        }
    }
    public void displayBookByGenre(Scanner sc){
        System.out.println("Enter the Book genre");
        String genre = sc.nextLine();
        int count = 0;
        for (Book book : books) {
            if(book.genre.equals(genre)){
                System.out.println(book);
                count++;
            }
        }
        if(count == 0){
            System.out.println("There is No Book Available in this Genre..");
        }
    }
    public void displayBookByAuthor(Scanner sc){
        System.out.println("Enter the Author Name");
        String authorName = sc.nextLine();
        int count = 0;
        for (Book book : books) {
            if(book.authorName.equals(authorName)){
                System.out.println(book);
                count++;
            }
        }
        if(count == 0){
            System.out.println("There is No Book Available in this Author Name..");
        }
    }
}
