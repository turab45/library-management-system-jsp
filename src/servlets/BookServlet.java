package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import dao.CategoryDao;
import daoimpl.BookDaoImpl;
import daoimpl.CategoryDaoImpl;
import models.Book;
import models.Category;
import models.Role;
import models.User;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/Book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDao categoryDaoImpl = new CategoryDaoImpl();
	BookDao bookDaoImpl = new BookDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String categoryName = request.getParameter("category");
		
		Category category = categoryDaoImpl.getCategoryById(categoryDaoImpl.getIdByName(categoryName));
		
		Integer noOfCopies = Integer.parseInt(request.getParameter("no-of-copies"));
		
		String action = request.getParameter("action");
		
		Book book = null;
		Integer id = null;
		Integer result = null;
		switch (action) {
		
		case "add":
			book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setCategory(category);
			book.setNoOfCopies(noOfCopies);
			book.setCreatedBy(u.getRole());
			
			result = bookDaoImpl.addBook(book);
			if (result > 0) {
				response.sendRedirect("view-book.jsp");
			}
			break;

		case "update":
			id = Integer.parseInt(request.getParameter("id"));
			book = bookDaoImpl.getBookById(id);
			book.setTitle(title);
			book.setAuthor(author);
			book.setCategory(category);
			book.setNoOfCopies(noOfCopies);
			book.setCreatedBy(u.getRole());
			break;
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			result = bookDaoImpl.deleteBook(id);
			
			if (result > 0) {
				response.sendRedirect("view-book.jsp");
			}else {
				response.getWriter().print("Error in deleting book!");
			}
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
