package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.UserDTO;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       response.setContentType("text/html");
       PrintWriter out  = response.getWriter();
		boolean check = false;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		

		System.out.println("u name= " + userName);
		System.out.println("u pwd= " + password);
		System.out.println("user name asdasd= " + userName);
		System.out.println("u pwd sadsad= " + password);

		UserDTO uDTO = new UserDTO();
		UserDAO uDAO = new UserDAO();

		uDTO.setUserName(userName);
		uDTO.setUserPassword(password);

		check = uDAO.checkUserExists(uDTO);

		System.out.println("User login check = " + check);
		if (check == true) {
			out.println("Login Success");
			/*RequestDispatcher rd = request
					.getRequestDispatcher("LoginSuccessUserServlet");
			rd.forward(request, response);*/
		} else {
			response.sendRedirect("home.jsp?err=usr");

		}
	}

}
