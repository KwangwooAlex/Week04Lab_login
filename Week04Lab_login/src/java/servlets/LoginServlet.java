package servlets;

import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//         String redirectURL = "http://localhost:8084/Week04Lab_login/home";
        
        
         HttpSession session = request.getSession();
            
         User before_user = (User)session.getAttribute("user");
                
         String action = request.getParameter("action");
         
         if(request.getParameter("logout")!=null){
            session.invalidate();
            session = request.getSession();//restart
            request.setAttribute("message", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
         }
//         if(action != null && action.equals("Logout")){
//                    session.invalidate();
//                    session = request.getSession();//restart
//                    request.setAttribute("message", "You have successfully logged out");
//         } 
         
         if(before_user != null){
             request.setAttribute("user", before_user);
             getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
//             request.setAttribute("message", "you have still storage");
//                response.sendRedirect("home.jsp");
//             getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
         }
         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        AccountService aS = new AccountService();
//        
//        HttpSession session = request.getSession();
//        
//        String name = request.getParameter("name") ;
//        String password = request.getParameter("password") ;
//        User user = aS.login(name, password);
//        
//        ArrayList<User> nameList = (ArrayList<User>)session.getAttribute("nameList");
//        if(nameList == null){
//            nameList = new ArrayList<>();
//         }
//        
//        if(user != null){
//           nameList.add(user);
//           session.setAttribute("nameList",nameList);
////            request.setAttribute("name", name);
//            String username= user.getUsername();
//            request.setAttribute("name", username);
//            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
//        }
        
         getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        
    }


}
