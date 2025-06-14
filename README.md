import java.util.*;

class User {
    private String name;
    private String username;
    private String password;
    private double balance = 50000.0;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        this.balance -= amount;
    }
}

class Book {
    private static int counter = 1;
    private int id;
    private String title;
    private double price;
    private String content;
    private int totalCopies;

    public Book(String title, double price, String content, int totalCopies) {
        this.id = counter++;
        this.title = title;
        this.price = price;
        this.content = content;
        this.totalCopies = totalCopies;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }

    public int getTotalCopies() {
        return totalCopies;
    }
}

class LoginManager {
    public User login(String username, String password, List<User> users) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean register(String name, String username, String password, List<User> users) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        users.add(new User(name, username, password));
        return true;
    }
}

class LibraryManager {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public LibraryManager() {
        books.add(new Book("Harry Potter", 250, "Magic and adventure in Hogwarts.", 5));
        books.add(new Book("The Alchemist", 300, "A journey of finding one's destiny.", 3));
        books.add(new Book("Wings of Fire", 200, "Biography of Dr. A.P.J Abdul Kalam.", 4));
        books.add(new Book("To Kill a Mockingbird", 280, "A story of racial injustice and childhood innocence.", 2));
        books.add(new Book("1984", 320, "Dystopian future under surveillance.", 6));
        books.add(new Book("Pride and Prejudice", 260, "Romantic tale of manners and marriage.", 4));
        books.add(new Book("The Great Gatsby", 270, "The American dream and social upheaval.", 3));
        books.add(new Book("The Hobbit", 350, "An epic quest in Middle-earth.", 5));
        books.add(new Book("The Catcher in the Rye", 310, "A teen's journey through disillusionment.", 2));
        books.add(new Book("Sapiens", 400, "Brief history of humankind.", 3));
        books.add(new Book("Ikigai", 200, "The Japanese secret to a long and happy life.", 4));
        books.add(new Book("Rich Dad Poor Dad", 330, "Financial education and mindset.", 5));
        books.add(new Book("Atomic Habits", 350, "An easy & proven way to build good habits.", 6));
        books.add(new Book("Think and Grow Rich", 290, "Philosophy of personal achievement.", 3));
        books.add(new Book("The Power of Now", 310, "Spiritual awakening and mindfulness.", 4));
        books.add(new Book("The Subtle Art of Not Giving a F*ck", 380, "A counterintuitive approach to living.", 2));
        books.add(new Book("The Psychology of Money", 360, "Timeless lessons on wealth, greed, and happiness.", 3));
        books.add(new Book("A Brief History of Time", 290, "Stephen Hawking explains universe's secrets.", 3));
        books.add(new Book("The Book Thief", 340, "A story of words and Nazi Germany.", 2));
        books.add(new Book("The Kite Runner", 330, "Friendship, guilt, and redemption in Afghanistan.", 3));
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getAllUsers() {
        return users;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager library = new LibraryManager();
        LoginManager loginManager = new LoginManager();

        User currentUser = null;

        while (currentUser == null) {
            System.out.println("\n1. Login\n2. Register\n3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Username: ");
                    String username = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();
                    currentUser = loginManager.login(username, password, library.getAllUsers());
                    if (currentUser == null) {
                        System.out.println("Invalid username or password.");
                    } else {
                        System.out.println("Welcome, " + currentUser.getName() + "!");
                    }
                    break;
                case 2:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Username: ");
                    username = sc.nextLine();
                    System.out.print("Password: ");
                    password = sc.nextLine();
                    boolean success = loginManager.register(name, username, password, library.getAllUsers());
                    System.out.println(success ? "Registration successful." : "Username already exists.");
                    break;
                case 3:
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        while (true) {
            System.out.println("\n--- Book Menu ---");
            List<Book> books = library.getBooks();
            for (Book b : books) {
                System.out.println(b.getId() + ". " + b.getTitle() + " (₹" + b.getPrice() + ", Copies: " + b.getTotalCopies() + ")");
            }
            System.out.println("0. Logout");
            System.out.print("Choose a book to view/buy: ");
            int bookChoice = sc.nextInt();
            sc.nextLine();

            if (bookChoice == 0) {
                System.out.println("Logging out...");
                break;
            }

            Book selected = null;
            for (Book b : books) {
                if (b.getId() == bookChoice) {
                    selected = b;
                    break;
                }
            }

            if (selected != null) {
                System.out.println("\n--- " + selected.getTitle() + " ---");
                System.out.println("Content: " + selected.getContent());
                System.out.println("Price: ₹" + selected.getPrice());
                System.out.println("Total Copies: " + selected.getTotalCopies());
                System.out.println("Your Balance: ₹" + currentUser.getBalance());
                System.out.print("Buy this book? (yes/no): ");
                String buy = sc.nextLine();

                if (buy.equalsIgnoreCase("yes")) {
                    if (currentUser.getBalance() >= selected.getPrice()) {
                        currentUser.deductBalance(selected.getPrice());
                        System.out.println("You bought the book! ₹" + selected.getPrice() + " deducted.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
//JUST MODIFIED IT ADDED BALACE TO BUY BOOKS ALSO ADDED MORE BOOKS
