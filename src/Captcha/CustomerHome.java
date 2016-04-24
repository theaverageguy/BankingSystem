package Captcha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customerhome")
public class CustomerHome extends HttpServlet {
	/*
	 * This is customer's home page after he gets logged in.
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request,resonse);
		
		PrintWriter out = response.getWriter();
		Long account_number = TestLogin.account_number;
		String first_name = null;
		String last_name = null;
		String gender = null;
		Date dob = null;
		String email = null;
		Long mobile_number = null;
		String house_number = null;
		String street = null;
		String district = null;
		String city = null;
		Integer pincode = null;
		String state = null;
		Long balance = null;
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/online_banking_system";

		   //  Database credentials
		    final String USER = "root";
		   final String PASS = "yash$123456";
		
		String query = "SELECT * FROM customer_personal_info natural join customer_contact_info natural join"
				+ " customer_residence_info natural join customer_account_info"
				+ " where account_number = " + account_number;
		
		try {		
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			
			if(rs.next()) {
				first_name = rs.getString("first_name");
				last_name = rs.getString("last_name");
				gender = rs.getString("gender");
				dob = rs.getDate("dob");
				email = rs.getString("email");
				mobile_number = rs.getLong("mobile_number");
				house_number = rs.getString("house_number");
				street = rs.getString("street");
				district = rs.getString("district");
				city = rs.getString("city");
				pincode = rs.getInt("pincode");
				state = rs.getString("state");
				balance = rs.getLong("balance");
			}
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
		out.println("<!DOCTYPE html> <html lang=\"en\"><head><!-- Meta information --><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><!-- Title of the website --><title>OnlineBankingSystem</title><!-- Bootstrap CSS --><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"><!-- Font awesome --><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css\"><!-- Custom CSS files --><link rel=\"stylesheet\" href=\"css/custom_style.css\"><!-- Google Font --><link href=\"http://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\"></head><body><nav class=\"navbar navbar-fixed-top\" role=\"navigation\"><div class=\"navbar-header\"><button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\"><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button><a class=\"navbar-brand\" href=\"index.html\"><img src=\"img/bank.png\" height=80 width=100 style=\"margin-top: -30px\"></a></div><div class=\"navbar-collapse collapse\"><ul class=\"nav navbar-nav\"><li><a href=\"tranfer.html\"><i class=\"fa fa-inr fa-lg\"></i> Tranfer Money</a></li><li><a href=\"#\"><i class=\"glyphicon glyphicon-user\"></i> Update Profile</a></li><li><a href=\"#\"><i class=\"fa fa-question fa-lg\"></i> FAQ</a></li></ul></div></nav><header class=\"jumbotron jumb\"><div class=\"container\"><h2 style=\"text-decoration: underline; letter-spacing: 5px; font-family: 'Montserrat', sans-serif\">Welcome</h2><br><h3 style=\"letter-spacing: 5px; font-family: 'Montserrat', sans-serif\">Your Details</h3><br>");
		
		out.println("<table style=\"width:100%\">");
		out.println("<tr>");
		out.println("<td>" + "first_name"  + "</td>");
		out.println("<td>" + first_name  + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "last_name" + "</td>");
		out.println("<td>" + last_name + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "gender" + "</td>");
		out.println("<td>" + gender + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "dob" + "</td>");
		out.println("<td>" + dob + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "email" + "</td>");
		out.println("<td>" + email + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "mobile_number" + "</td>");
		out.println("<td>" + mobile_number + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "house_number" + "</td>");
		out.println("<td>" + house_number + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "street" + "</td>");
		out.println("<td>" + street + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "district" + "</td>");
		out.println("<td>" + district + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "city" + "</td>");
		out.println("<td>" + city + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "pincode" + "</td>");
		out.println("<td>" + pincode + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "state" + "</td>");
		out.println("<td>" + state + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "account_number" + "</td>");
		out.println("<td>" + account_number + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "balance" + "</td>");
		out.println("<td>" + balance + "</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</div></header></body></html>");
		out.println("<form action=\"transfer.html\"><button type=\"submit\" class=\"btn btn-default btn-lg\">Make A Transaction</button></form>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.sendRedirect("infodisp.html");
	}

}
