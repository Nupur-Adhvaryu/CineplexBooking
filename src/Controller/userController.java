package Controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import DButil.moviesDB;
import model.Movies;
import javax.annotation.Resource;
import javax.sql.DataSource;
import model.User;



public class userController extends HttpServlet {
	private User u;
	private int discount;
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/prog32758")
       private DataSource datasource;
       private moviesDB moviesDb; 
	 public void init() throws ServletException{
  	   
  	   super.init();
  	   
  	   try {
  		   moviesDb = new moviesDB(datasource);
  		   
  	   }
  	   catch(Exception ex) {
  		   throw new ServletException(ex);
  	   }
     }
    public userController() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/userRegistration.jsp");
		dispatcher.forward(request,response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String user = request.getParameter("hidden");
	if(user.equals("admin")) {
		if((request.getParameter("name")).equals("Nupur") && request.getParameter("pass").equals("123")) {
			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request,response);
		}

	}
	else if (user.equals("user")) {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		u = new User(fname,lname,email,uname,pass);
		
		try {
			if(moviesDb.check(u)) {
				discount = Integer.parseInt(request.getParameter("discount"));
				list(request,response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request,response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else if(user.equals("userRegister")) {
		try {
			addUser(request,response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/thanks.jsp");
			dispatcher.forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	else if(user.equals("listUser")) {
		try {
			listUsers(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	else {
		System.out.print("not working");
	}
	
		//doGet(request, response);
	}
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		u = new User(fname,lname,email,uname,pass);
		try {
			moviesDb.addUser(u);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void listUsers(HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<User> users = moviesDb.getUsers();
		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listUsers.jsp");
		dispatcher.forward(request,response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)throws Exception {
		if(discount>0) {
			request.setAttribute("dis",discount);
		}
		List<Movies> movies = moviesDb.getMovies();
		request.setAttribute("movies", movies);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listMovies.jsp");
		dispatcher.forward(request,response);
	}


}
