package manager;
import java.util.ArrayList;
import model.*;


public class LoginManager {

    public User login(String u,String p,ArrayList<User> users)
    {
        for((User user:users))
        {
            String tempUserName=user.getusername();
            String tempPassword=user.getpassword();
            if(tempUserName.equals(u) && tempPassword.euals(p))
            {
                return user;
            }
        }
        return null;
    }
    
}
