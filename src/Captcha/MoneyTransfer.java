package Captcha;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class MoneyTransfer
 */
@WebServlet("/MoneyTransfer")
public class MoneyTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneyTransfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		Long account_number = (long)1000000000;
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/online_banking_system";

		   //  Database credentials
		    final String USER = "root";
		   final String PASS = "yash$123456";
		  
			
		   out.println("<!DOCTYPE html> <html lang=\"en\"><head><!-- Meta information --><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><!-- Title of the website --><title>OnlineBankingSystem</title><!-- Bootstrap CSS --><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"><!-- Font awesome --><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css\"><!-- Custom CSS files --><link rel=\"stylesheet\" href=\"css/custom_style.css\"><!-- Google Font --><link href=\"http://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\"></head><body><nav class=\"navbar navbar-fixed-top\" role=\"navigation\"><div class=\"navbar-header\"><button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\"><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button><a class=\"navbar-brand\" href=\"index.html\"><img src=\"img/bank.png\" height=80 width=100 style=\"margin-top: -30px\"></a></div><div class=\"navbar-collapse collapse\"><ul class=\"nav navbar-nav\"><li><a href=\"tranfer.html\"><i class=\"fa fa-inr fa-lg\"></i> Tranfer Money</a></li><li><a href=\"#\"><i class=\"glyphicon glyphicon-user\"></i> Update Profile</a></li><li><a href=\"#\"><i class=\"fa fa-question fa-lg\"></i> FAQ</a></li></ul></div></nav><header class=\"jumbotron jumb\"><div class=\"container\"><h2 style=\"text-decoration: underline; letter-spacing: 5px; font-family: 'Montserrat', sans-serif\">Welcome</h2><br><h3 style=\"letter-spacing: 5px; font-family: 'Montserrat', sans-serif\">Your Transactions</h3><br>");
		   out.println("<table style=\"width:100%\">");
		   String query = "SELECT * FROM customer_transaction_info"
					+ " where account_number = " + account_number;
		  
		   Long transfer_number = null;
		   int amount = 0;
		   String date = null;
		   
		   
		   try {		
			   Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(DB_URL,USER,PASS);
				statement = connection.createStatement();
				rs = statement.executeQuery(query);
				
				while(rs.next()) {
					
					transfer_number = rs.getLong("transfer_number");
					amount = rs.getInt("amount");
					date = rs.getString("date");
					
					
					out.println("<tr>");
					out.println("<td>" + "trasfer_number"  + "</td>");
					out.println("<td>" + transfer_number  + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>" + "amount" + "</td>");
					out.println("<td>" + amount + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>" + "date" + "</td>");
					out.println("<td>" + date + "</td>");
					out.println("</tr>");
					
					
					
					
				}
				
				out.println("</table>");
				out.println("<center><form id=\"transaction-form1\" name=\"form2\" class=\"form-horizontal\" role=\"form\" method=\"POST\" action=\"MoneyTransfer2\"><br><button type=\"submit\" class=\"btn btn-default btn-lg\">Make a Transaction</button></form></center>");
				out.println("</div></header></body></html>");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (connection != null) {
					try {
						/*
						 * Closing the Connection object will also close Statement object as well.
						 * However, we should always explicitly close the Statement object to ensure proper cleanup.
						 */
						statement.close();
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		   
			
		   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
