package servlets;

import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountService extends HttpServlet {
        public User login(String username, String password){
            if( (username.equals("adam") || username.equals("betty")) && password.equals("password")){
                return new User(username, null);
            }
            return null;
        }
}
