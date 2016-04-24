package Captcha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoneyTransfer3
 */
@WebServlet("/MoneyTransfer3")
public class MoneyTransfer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneyTransfer3() {
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
		String amount = request.getParameter("amount");
		String transfer_number = request.getParameter("transfer_number");
		String ifsc = request.getParameter("ifsc");
		//System.out.println(""+amount);
			//	System.out.println(""+transfer_number);
			//	System.out.println(""+ifsc);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html> <html lang=\"en\"><head><!-- Meta information --><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><!-- Title of the website --><title>OnlineBankingSystem</title><!-- Bootstrap CSS --><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"><!-- Font awesome --><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css\"><!-- Custom CSS files --><link rel=\"stylesheet\" href=\"css/custom_style.css\"><!-- Google Font --><link href=\"http://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\"></head><body><nav class=\"navbar navbar-fixed-top\" role=\"navigation\"><div class=\"navbar-header\"><button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\"><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button><a class=\"navbar-brand\" href=\"index.html\"><img src=\"img/bank.png\" height=80 width=100 style=\"margin-top: -30px\"></a></div><div class=\"navbar-collapse collapse\"><ul class=\"nav navbar-nav\"><li><a href=\"tranfer.html\"><i class=\"fa fa-inr fa-lg\"></i> Tranfer Money</a></li><li><a href=\"#\"><i class=\"glyphicon glyphicon-user\"></i> Update Profile</a></li><li><a href=\"#\"><i class=\"fa fa-question fa-lg\"></i> FAQ</a></li></ul></div></nav><header class=\"jumbotron jumb\"><div class=\"container\"><h2 style=\"text-decoration: underline; letter-spacing: 5px; font-family: 'Montserrat', sans-serif\">Welcome</h2><br><h3 style=\"letter-spacing: 5px; font-family: 'Montserrat', sans-serif\">transaction details</h3><br>");
		 out.println("<table style=\"width:100%\">");
		 out.println("<tr>");
			out.println("<td>" + "trasfer_number"  + "</td>");
			out.println("<td>" + transfer_number  + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>" + "amount" + "</td>");
			out.println("<td>" + amount + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>" + "ifsc" + "</td>");
			out.println("<td>" + ifsc + "</td>");
			out.println("</tr>");
			out.println("<br><br>");
			
		out.println("<form id=\"login-form\" name=\"form\" class=\"form-horizontal\" role=\"form\" method=\"POST\" action=\"MoneyTransfer4\"><input type=\"text\" class=\"form-control\" name=\"username\" placeholder=\"Enter Username\" required><br><input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Password\" required><br><button type=\"submit\" class=\"btn btn-default btn-lg\">Transfer</button></form>");
		
		
		//doGet(request, response);
	}

}
