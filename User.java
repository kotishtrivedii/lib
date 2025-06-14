package model;
import java.util.*;
public class User
{
    private int userId;
    private String name;
    private String username;
    private String password;
    private boolean isAdmin;
    private ArrayList<Integer> borrowedBookId=new ArrayList<>();

    public User(int userId,String name,String username,String password,boolean isAdmin)
    {
        this.userId=userId;
        this.name=name;
        this.username=username;
        this.password=password;
        this.isAdmin=isAdmin;
    }
    public int getUserId()
    {
        return userId;
    }

    public String getname()
    {
        return name;
    }
    public String getusername()
    {
        return username;
    }
    public String password()
    {
        return password;
    }
    public boolean getisAdmin()
    {
        return isAdmin;
    }
    public void borrowBook(int bookId)
    {
        borrowedBookId.add(bookId);
    }
    public void returnBook(int bookId)
    {
        borrowedBookId.remove(bookId);
    }
    public void ShowBorrowedBooks()
    {
        if(borrowedBookId.isEmpty())
        {
            System.out.println("No books borrowed");
        }
        else{
            System.out.println("Borrowed books: "+borrowedBookId);            
        }
    }


}