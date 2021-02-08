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



public class MoviesController extends HttpServlet {
	
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
    public MoviesController() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {
		if(request.getParameter("hidden").equals("add")) {
			addMovie(request,response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/movieAdded.jsp");
			dispatcher.forward(request,response);
		}
		if(request.getParameter("hidden").equals("list"))
			list(request,response);
		
		
		if(request.getParameter("hidden").equals("listMovie")) {
			listToDelete(request,response);
		}
			
			
		if(request.getParameter("hidden").equals("delete")) {
			int id = Integer.parseInt(request.getParameter("Movie"));
			moviesDb.deleteMovie(id);
			listToDelete(request,response);
		}
	}
	catch (Exception e) {
		
		e.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	private void addMovie(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("serId"));
		String movie = request.getParameter("name");
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		int seats = Integer.parseInt(request.getParameter("seats"));
		Movies newMovie = new Movies(id,movie,day,time,seats);
		
		try {
			moviesDb.addMovie(newMovie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response)throws Exception {
		List<Movies> movies = moviesDb.getMovies();
		request.setAttribute("movies", movies);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listMoviesGuest.jsp");
		dispatcher.forward(request,response);
		
	}
	private void listToDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Movies> movies = moviesDb.getMovies();
		request.setAttribute("movies", movies);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminDel.jsp");
		dispatcher.forward(request,response);
		
	}
//	private void delete(HttpServletRequest request, HttpServletResponse response)throws Exception  {
//		List<Movies> movies = moviesDb.getMovies();
//		request.setAttribute("movies", movies);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/listMovies.jsp");
//		dispatcher.forward(request,response);
//		
//	}
	

}
