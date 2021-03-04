package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RoleDao;
import daoimpl.RoleDaoImpl;
import models.Role;
import models.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoleDao roleDaoImpl = new RoleDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String role = request.getParameter("role");
		
		System.out.println(name+", "+email+", "+pass+", "+role);
		String action = request.getParameter("action");
		
		switch (action) {
		case "add":
			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(pass);
			
			Role role2 = roleDaoImpl.getRoleById(roleDaoImpl.getRoleIdByName(role));
			user.setRole(role2);
			user.setCreatedBy(u.getRole());
			break;

		default:
			break;
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
