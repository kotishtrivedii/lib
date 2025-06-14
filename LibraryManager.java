package manager;
import model.*;
import java.util.ArrayList;

public class LibraryManager 
{
    ArrayList<Book> books=new ArrayList<>();  
    ArrayList<User> users=new ArrayList<>();
    public void addBook(Book b)
    {
        books.add(b);
    }

    public void addUser(User u)
    {
        users.add(u);
    }

    public void viewAllBooks()
    {
        for(Book b:books)
        {
            System.out.println(b);
        }
    }

    public ArrayList<User> getAllUsers()
    {
        return users;
    }

    public Book getBookbyId(int bookId)
    {
        for(Book b:books)
        {
            if(b.getBookId()==bookId)
            {
                return b;
            }

        }return null;
    }

    public User getUserbyId(int userId)
    {
        for(User u:users)
        {
            if(u.getUserId()==userId)
            {
                return u;
            }
        }
        return null;
    }

    public void searchBookByTitle(String t)
    {
        String title=t.toLowerCase();
        boolean found=false;
        for(Book b:books)
        {
            String bookTitle=b.getTitle().toLowerCase();
            if(bookTitle.contains(title))
            {
                found=true;
                System.out.println(b);
            }
        }
        if(found==false)
        System.out.println("Books Not Found");
    }

    public void  borrowBook(int bookId,int userId)
    {
        Book b=getBookbyId(bookId);
        User u=getUserbyId(userId);
        if(b!=null && u!=null && b.getAvailableCopies()>0)
        {
            b.decreaseCopies();
            u.borrowBook(bookId);
            System.out.println("Book borrowed successfully");
        }
        else
        {
            System.out.println("Unable to borrow book");
        }
    }

    public void returnBook(int bookId,int userId)
    {
        Book b=getBookbyId(bookId);
        User u=getUserbyId(userId);
        if(b!=null && u!=null)
        {
            b.increaseCopies();
            u.returnBook(bookId);
            System.out.println("Book returned successfully");
        }
        else{
            System.out.println("Unable to return book");
        }
    }
}

