package daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.ISUB;

import dao.IssueDao;
import models.Book;
import models.Issue;
import models.Role;
import models.Student;
import models.User;
import sun.security.x509.SubjectKeyIdentifierExtension;
import util.Database;

public class IssueDaoImpl implements IssueDao{
	
	Connection conn = Database.getConnection();

	@Override
	public Integer addIssue(Issue issue) {
		Integer row = null;
        try {
            
            java.sql.Date createdDate = new Date(new java.util.Date().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO issue(`book-id`,`student-id`,`issue-date`,`issued-by`,create_date,created_by,`status`) VALUES(?,?,?,?,?,?,1)");
            pstmt.setInt(1, issue.getBook().getId());
            pstmt.setInt(2, issue.getStudent().getId());
            pstmt.setDate(3, createdDate);
            pstmt.setInt(4, issue.getIssuedBy().getId());
            pstmt.setDate(5, createdDate);
            pstmt.setInt(6, issue.getCreatedBy().getId());
           
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer updateIssue(Issue issue) {
		Integer row = null;
        try {
            
            java.sql.Date updatedDate = new Date(new java.util.Date().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE issue SET book-id=?,student-id=?,issued-by=?,update_date=?,updated_by=? WHERE id=?");
            pstmt.setInt(1, issue.getBook().getId());
            pstmt.setInt(2, issue.getStudent().getId());
            pstmt.setInt(3, issue.getIssuedBy().getId());
            pstmt.setDate(4, updatedDate);
            pstmt.setInt(5, issue.getUpdatedBy().getId());
            pstmt.setInt(6, issue.getId());
           
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer deleteIssue(Integer id) {
		Integer row = null;
        try {
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE issue SET status=0 WHERE id=?");
            pstmt.setInt(1, id);
           
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Issue getIssueById(Integer id) {
		Issue issue = null;
		ResultSet rs = null;
        try {
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM issue WHERE id=? and status>0");
            pstmt.setInt(1, id);
                        
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
				issue = new Issue();
				issue.setId(rs.getInt("id"));
				
				Book book = new Book();
				book.setId(rs.getInt("book-id"));
				Student student = new Student();
				student.setId(rs.getInt("student-id"));
				User user = new User();
				user.setId(rs.getInt("issued-by"));
				
				Role r1 = new Role();
				r1.setId(rs.getInt("created_by"));
				Role r2 = new Role();
				r2.setId(rs.getInt("updated_by"));
				
				issue.setBook(book);
				issue.setStudent(student);
				issue.setIssuedBy(user);
				issue.setCreateDate(rs.getDate("create_date"));
				issue.setCreatedBy(r1);
				issue.setUpdateDate(rs.getDate("update_date"));
				issue.setUpdatedBy(r2);
				
            }
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return issue;
	}

	@Override
	public List<Issue> getAllIssue() {
		List<Issue> allIssue = new ArrayList<Issue>();
		ResultSet rs = null;
        try {
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM issue WHERE status>0");
                        
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
				Issue issue = new Issue();
				issue.setId(rs.getInt("id"));
				
				Book book = new Book();
				book.setId(rs.getInt("book-id"));
				Student student = new Student();
				student.setId(rs.getInt("student-id"));
				User user = new User();
				user.setId(rs.getInt("issued-by"));
				
				Role r1 = new Role();
				r1.setId(rs.getInt("created_by"));
				Role r2 = new Role();
				r2.setId(rs.getInt("updated_by"));
				
				issue.setBook(book);
				issue.setStudent(student);
				issue.setIssuedBy(user);
				issue.setCreateDate(rs.getDate("create_date"));
				issue.setCreatedBy(r1);
				issue.setUpdateDate(rs.getDate("update_date"));
				issue.setUpdatedBy(r2);
				
				allIssue.add(issue);
            }
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return allIssue;
	}

	@Override
	public Integer getIdByBookandStudent(Integer bookId, Integer studentID) {
		Integer id = null;
		ResultSet rs = null;
        try {
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM issue WHERE book-id=? and student-id=? and status>0");
            pstmt.setInt(1, bookId);
            pstmt.setInt(1, studentID);
                        
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
				id = rs.getInt("id");
			}
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return id;
	}

}
