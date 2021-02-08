package Controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import model.Movies;
import DButil.moviesDB;
/**
 * Servlet implementation class ticketController
 */
public class ticketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/prog32758")
    private DataSource datasource;
    private moviesDB moviesDb;
    Movies m = null;
    private int dis = 0;
	 public void init() throws ServletException{
	   
	   super.init();
	   
	   try {
		   moviesDb = new moviesDB(datasource);
		   
	   }
	   catch(Exception ex) {
		   throw new ServletException(ex);
	   }
  }
    public ticketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("Movie"));
		
			try {
				m = moviesDb.getMovie(id);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(request.getParameter("dis")!=null) {	
		dis = Integer.parseInt(request.getParameter("dis"));
		}
		else {
			dis = 0;
		}
		request.setAttribute("selectedMovie", m);
		request.getRequestDispatcher("/recipt.jsp").forward(request, response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double price = 0;
//		if(m.getDay().toUpperCase().equals("TUESDAY")) {
//			price = price - 5;
//		}
		int i1 = Integer.parseInt(request.getParameter("gVal"));
		int i2 = Integer.parseInt(request.getParameter("kVal"));
		int i3 = Integer.parseInt(request.getParameter("sVal"));
		String[] category = request.getParameterValues("category");
		for(int i = 0; i<category.length;i++) {
			
		
		if(category[i].equals("general")) {
			if((m.getDay().toLowerCase()).equals("tuesday")) {
				price += i1*5;
			}
			else
				price += i1*15;
		}
		else if(category[i].equals("kid")) {
			price += i2*5;
		}
		else if(category[i].equals("senior")) {
			price += i3*5;
		}
		}
		price = price - (price*dis)/100;
		int totalTickets = i1+i2+i3;
		try {
			moviesDb.bookSeats(m.getId(),totalTickets);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("hahahhahahhhah");
			e.printStackTrace();
			request.setAttribute("tt", totalTickets);
			request.getRequestDispatcher("/seatError.jsp").forward(request, response);		
		}
		request.setAttribute("tt", totalTickets);
		request.setAttribute("price", price);
		request.setAttribute("movies", m);
		request.getRequestDispatcher("/ticket.jsp").forward(request, response);		
	}
	
}
