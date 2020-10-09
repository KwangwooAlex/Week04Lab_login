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


public class HomeServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            User before_user = (User)session.getAttribute("user");
            request.setAttribute("user", before_user);
//            String action = request.getParameter("action");
//                if(action != null && action.equals("Logout")){
//                    session.invalidate();
//                    session = request.getSession();//restart
//                    request.setAttribute("message", "You have successfully logged out");
//                    response.sendRedirect("login.jsp");
//                }     
            if(before_user != null){
                    getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            }else{
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
             
        
         
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession();
//             String action = request.getParameter("logout");
//                if(action != null && action.equals("logout")){
//                    session.invalidate();
//                    session = request.getSession();//restart
//                    request.setAttribute("message", "You have successfully logged out");
//                }     
                 
        
        
            AccountService aS = new AccountService();
            
            
            User before_user = (User)session.getAttribute("user");
            
            if(before_user != null){
                request.setAttribute("user", before_user);
                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            }else{
                String name = request.getParameter("username") ;
                String password = request.getParameter("password") ;

                User user = aS.login(name, password);

                session.setAttribute("user",user);

                if(user == null){
                         request.setAttribute("message", "You are not allowed to login");
                         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                }else{
                        request.setAttribute("user", user);
                        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
                }
                
               
            }
            
            
            
            
//            User s_user = (User)session.getAttribute("user");
//            User before_user = aS.login(s_user.getUsername(),s_user.getPassword());
//            if(before_user != null){
//                request.setAttribute("user", before_user);
//                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
//            }else{
//                User user = aS.login(name, password);   
//                if(user == null){
//                  getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//                  request.setAttribute("message", "You are not allowed to login");
//                }else{
//                  session.setAttribute("user",user);
//                  getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
//                }
//            }
//            
//            
//            User user = aS.login(name, password);       
//            
//            
//            
//            
//            request.setAttribute("user", user);
//            
//            if(user != null){
//                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
//                
//            }else{
//                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//                request.setAttribute("message", "You must give your current age");
//            }
           
            
//            AccountService aS = new AccountService();
//
//           HttpSession session = request.getSession();
//
//           String name = request.getParameter("name") ;
//           String password = request.getParameter("password") ;
//           User user = aS.login(name, password);
//
//           ArrayList<User> nameList = (ArrayList<User>)session.getAttribute("nameList");
//           if(nameList == null){
//               nameList = new ArrayList<>();
//           }
//        
//            if(user != null){
//               nameList.add(user);
//               session.setAttribute("nameList",nameList);
//    //            request.setAttribute("name", name);
//                String username= user.getUsername();
//                request.setAttribute("name", username);
//                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
//            }
//            else{
//                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//            }
            
//            
//            
//            
//            
//            
//            
//            ArrayList<String> nameList = (ArrayList<String>)session.getAttribute("nameList");
//            if(nameList != null){
//                String user_name = nameList.get(0);
//                request.setAttribute("name", user_name);
//            }
//        
//            if(request.getParameter("logout")==null){
//                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
//            }else{
//                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//            }
      
    }
}
