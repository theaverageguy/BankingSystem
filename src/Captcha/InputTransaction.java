package Captcha;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestLogin
 */
@WebServlet("/Input")
public class InputTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//static Long account_number = null;  
	Long account_number = TestLogin.account_number;
	int globalc = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("amount");
		String password = request.getParameter("accnumber");
		//System.out.println(""+username);
		//System.out.println(""+password);
		
		  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/online_banking_system";

		   //  Database credentials
		    final String USER = "root";
		   final String PASS = "yash$123456";
		   
		   Connection conn = null;
		   Statement stmt = null;
		   
		   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT balance FROM customer_login_info NATURAL JOIN customer_account_info where account_number =" + Long.toString(account_number);
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      if(rs.next()){
			         //Retrieve by column name
			    	//  account_number = rs.getLong("account_number");
			    	  String balance = rs.getString("balance");
			    	  int bal = Integer.parseInt(balance);
			    	  System.out.println(bal);
			    	  int amt = Integer.parseInt(username);
			    	  if(bal>amt){
			    		  globalc = globalc + 1;
			    	  }
			    	  
			      }
			      else
					{
						response.sendRedirect("login_fail.html");
					}
			      //STEP 6: Clean-up environment
			      rs.close();
			      stmt.close();
			      conn.close();
			   }catch (SQLException e) {
					e.printStackTrace();
				}catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
		   
		   
		   
		   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT account_number FROM customer_login_info where account_number =" + password;
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      if(rs.next()){
			         //Retrieve by column name
			    	//  account_number = rs.getLong("account_number");
			    globalc = globalc+1;
			    
			    	  
			      }
			      else
					{
						response.sendRedirect("login_fail.html");
					}
			      //STEP 6: Clean-up environment
			      rs.close();
			      stmt.close();
			      conn.close();
			   }catch (SQLException e) {
					e.printStackTrace();
				}catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
		   
		   
		   if(globalc==2){
			   response.sendRedirect("index2.html");
		   }
		   
		
		
		//doGet(request, response);
			System.out.println("Verified accounts");
		//	response.sendRedirect("customerhome");
	}

}
