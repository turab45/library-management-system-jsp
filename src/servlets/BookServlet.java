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
import dao.IssueDao;
import dao.RoleDao;
import dao.StudentDao;
import daoimpl.BookDaoImpl;
import daoimpl.CategoryDaoImpl;
import daoimpl.IssueDaoImpl;
import daoimpl.RoleDaoImpl;
import daoimpl.StudentDaoImpl;
import models.Book;
import models.Category;
import models.Issue;
import models.Role;
import models.Student;
import models.User;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/Book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDao categoryDaoImpl = new CategoryDaoImpl();
	BookDao bookDaoImpl = new BookDaoImpl();
	RoleDao roleDaoImpl = new RoleDaoImpl();
	StudentDao studentDaoImpl = new StudentDaoImpl();
	IssueDao issueDaoImpl = new IssueDaoImpl();
       
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
		

		
		String action = request.getParameter("action");
		
		System.out.print("Action: "+action);
		System.out.print("No of copies: "+request.getParameter("no-of-copies"));
		
		Book book = null;
		Integer id = null;
		Integer result = null;
		switch (action) {
		
		case "add":
			Integer noOfCopies = Integer.parseInt(request.getParameter("no-of-copies"));
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
			
			noOfCopies = Integer.parseInt(request.getParameter("no-of-copies"));
			id = Integer.parseInt(request.getParameter("id"));
			book = bookDaoImpl.getBookById(id);
			book.setTitle(title);
			book.setAuthor(author);
			book.setCategory(category);
			book.setNoOfCopies(noOfCopies);
			
			Role role = new Role();
			role.setId(u.getRole().getId());
			
			book.setUpdatedBy(role);
			
			result = bookDaoImpl.updateBook(book);
			System.out.print("Result : "+result);
			if (result > 0) {
				response.sendRedirect("view-book.jsp");
			}
			
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
			
		case "issue":
			Integer bookId = Integer.parseInt(request.getParameter("book-id"));
			Integer studentId = Integer.parseInt(request.getParameter("student-id"));
			
			Book book2 = bookDaoImpl.getBookById(bookId);
			Student student = studentDaoImpl.getStudentById(studentId);
			
			Role createdBy = roleDaoImpl.getRoleById(u.getRole().getId());
			
			Issue issue = new Issue();
			issue.setBook(book2);
			issue.setStudent(student);
			issue.setCreatedBy(createdBy);
			issue.setIssuedBy(u);
			
			result = issueDaoImpl.addIssue(issue);
			
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
