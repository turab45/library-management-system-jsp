package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import daoimpl.UserDaoImpl;
import models.User;

/**
 * Servlet implementation class HandleServlet
 */
@WebServlet("/Handle")
public class HandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO userDaoImpl = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String useremail = request.getParameter("email");
		String pass = request.getParameter("password");
		
		Integer id = userDaoImpl.getUserIdByEmailandPass(useremail, pass);
		
		if (id != null) {
			User user = userDaoImpl.getUserById(id);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			response.sendRedirect("dashboard.jsp");
		}else {
			response.getWriter().print("Email & Password incorrect");
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
