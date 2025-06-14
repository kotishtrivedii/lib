import java.util.*;
import manager.*;
import model.*;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        LibraryManager library=new LibraryManager() ;
        LoginManager l=new LoginManager();
        
        User currentUser=null;
        while(currentUser==null)
        {
            System.out.println("1.login");
            System.out.println("2.Register");
            System.out.println("3.Exit");
            int choice=sc.nextInt();
            if(choice==1)
            {
                System.out.println("Enter your username");
                String username=sc.next();
                System.out.println("Enter your password");
                String password=sc.next();
                currentUser=l.login(username,password,library.getAllUsers());
                if(currentUser==null)
                {
                    System.out.println("Invalid username or password,Try Again");
                }
            }
            else if(choice==2)
            {
                System.out.println("Enter your name");
                String name=sc.next();
                System.out.println("Enter your username");
                String username=sc.next();
                System.out.println("Enter your password");
                String password=sc.next();
                int userId=1000+new Random().nextInt(9000);
                User newUser=new User(userId,name,username,password,false);
                library.addUser(newUser);
                System.out.println("User Registered Successfully, Please goto login page to access your account");
            }
            else if(choice==3)
            {
                System.out.println("Goodbye!...");
                return ;
            }
            else 
            {
                System.out.println("Invalid choice,Try Again");
            }
        }
    }    
}
