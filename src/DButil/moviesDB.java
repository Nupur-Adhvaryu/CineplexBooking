package DButil;
import java.sql.Connection;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.Movies;
public class moviesDB {
	private DataSource dataSource;
	// Movies//////////////////////////////
	public moviesDB(DataSource d) {
		this.dataSource = d;
	}
	
	public List<Movies> getMovies() throws SQLException{
		List<Movies> allMovies = new ArrayList<Movies>();
		
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		
		try {
		conn = dataSource.getConnection();
		String sql = "select * from schedule";
		ps = conn.createStatement();
		rs = ps.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String day = rs.getString(3);
			String time = rs.getString(4);
			int seats = rs.getInt(5);
			Movies m = new Movies(id,name,day,time,seats);
			allMovies.add(m);
		}
		
		
		
		}
		finally {
			close(conn,ps,rs);
		}
		
		return allMovies;
	}

	

	public void addMovie(Movies newMovie)  throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "Insert into schedule(movie_id,movie,movie_day,movie_time,movie_seats)values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, newMovie.getId());
			ps.setString(2, newMovie.getName());
			ps.setString(3,newMovie.getDay());
			ps.setString(4,newMovie.getTime());
			ps.setInt(5,newMovie.getSeats());
			ps.executeUpdate();
			}
			finally {
				close(conn,ps,null);
			}
			
		
	}
	public Movies getMovie(int id) throws Exception {
		Movies m = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		conn = dataSource.getConnection();
		String sql = "select * from schedule where movie_id = ?";
		
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		if(rs.next()) {
		String name = rs.getString(2);
		String day = rs.getString(3);
		String time = rs.getString(4);
		int seats = rs.getInt(5);
		m = new Movies(id,name,day,time,seats);
		}
		else {
			throw new Exception("Could not find MovieId "+id);
		}
		return m;
		
		
		
		}
		finally {
			close(conn,ps,rs);
		}
	}
	public void deleteMovie(int id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
		conn = dataSource.getConnection();
		String sql = "Delete from schedule where movie_id = ?";
		
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		}
		finally {
			close(conn,ps,null);
		}
	}
	public void bookSeats(int id,int t)  throws Exception {
		int seats = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql="Select * from schedule where movie_id = ?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if(rs.next()) {
				seats = rs.getInt(5);
				if(seats-t<0) {
					System.out.print("yesssssssssss");
					throw new Exception();
				}
			}
			else {
				System.err.print("Cannot Book Seats");
				throw new SQLException();
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,ps,rs);
		}
		try {
			conn = dataSource.getConnection();
			String sql1 = "Update schedule set movie_seats = ? where Movie_id = ?";
			ps=conn.prepareStatement(sql1);
			ps.setInt(1,seats-t);
			ps.setInt(2,id);
			ps.executeUpdate();
			if(ps.executeUpdate()>0) {
				System.out.print("UPDATEDDDD");
			}
			else {
				System.err.print("Cannot Update");
				throw new SQLException();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,ps,rs);
		}
		
		
	}
	// Users//////////////////////////////
	public void addUser(User u)  throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "Insert into user(fname,lname,email,username,user_password)values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getfName());
			ps.setString(2, u.getlName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getUserName());
			ps.setString(5, u.getPass());
			ps.executeUpdate();
			}
			finally {
				close(conn,ps,null);
			}
	}

	public boolean check(User u) throws Exception{
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		
		try {
		conn = dataSource.getConnection();
		String sql = "select * from user";
		ps = conn.createStatement();
		rs = ps.executeQuery(sql);
		while(rs.next()) {
			String name = rs.getString(4);
			String pass = rs.getString(5);
			if(name.equals(u.getUserName())&&pass.equals(u.getPass())) {
				return true;
			}	
		}
		
		}
		finally {
			close(conn,ps,rs);
		}
		
		return false;
		
	}
	public List<User> getUsers() throws Exception{
		List<User> allUser = new ArrayList<User>();
		
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		
		try {
		conn = dataSource.getConnection();
		String sql = "select * from user";
		ps = conn.createStatement();
		rs = ps.executeQuery(sql);
		while(rs.next()) {
			String fName = rs.getString(1);
			String lName = rs.getString(2);
			String email = rs.getString(3);
			String uName = rs.getString(4);
			String pass = rs.getString(5);
			User u = new User(fName,lName,email,uName,pass);
			allUser.add(u);
		}
		
		
		
		}
		finally {
			close(conn,ps,rs);
		}
		
		return allUser;
	}
	//close////
	private void close(Connection conn, Statement ps, ResultSet rs) 
			throws SQLException{
				// TODO Auto-generated method stub
				if(conn!=null)
					conn.close();
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
			
		}

	

	
}
