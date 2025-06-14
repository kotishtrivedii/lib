package model;
public class Book
{
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int totalCopies;
    private int availableCopies;

    public Book(int bookId, String title, String author, String publisher, int year, int totalCopies,int availableCopies)
    {
        this.bookId = bookId;
        this.title=title;
        this.author=author;
        this.publisher=publisher;
        this.year=year;
        this.totalCopies=totalCopies;
        this.availableCopies=availableCopies;
    }

    public int getBookId()
    {
        return bookId;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public int getYear()
    {
        return year;
    }

    public int getTotalCopies()
    {
        return totalCopies;
    }

    public int getAvailableCopies()
    {
        return availableCopies;
    }

    public void increaseCopies()
    {
        this.availableCopies++;
    }
    public void decreaseCopies()
    {
        if(this.availableCopies>0)
        this.availableCopies--;
        else
        System.out.println("No copies available");
    }
    public String fullDetails()
    {
        return "Book ID: "+bookId+"\nTitle: "+title+"\nAuthor: "+"\nYear: "+year+"\nPublisher: "+publisher+"\nTotal Copies: "+totalCopies+"\nAvailableCopies: "+availableCopies;
    }
    
    
}