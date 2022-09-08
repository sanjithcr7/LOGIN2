package login2;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class RegisServlet
 */
@WebServlet("/regis")
public class RegisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    /**
     * Default constructor. 
     */
    public RegisServlet() {
        // TODO Auto-generated constructor stub
    }
    public void init()throws ServletException{
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String s1=request.getParameter("name");
			String s2=request.getParameter("email");
			String s3=request.getParameter("uname");
			String s4=request.getParameter("pword");
			PreparedStatement ps=con.prepareStatement("insert into uinfo2 values(?,?,?,?)");
			ps.setString(1,s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			ps.setString(4, s4);
			ps.executeUpdate();			
			PrintWriter pw=response.getWriter();
			pw.println("<html><body>");
			pw.println("Your are Successfully registered <br>");
			pw.println("<a href=login.html>Login</a>");
			pw.println("</body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
