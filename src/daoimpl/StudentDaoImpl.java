package daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import models.Role;
import models.Student;
import util.Database;

public class StudentDaoImpl implements StudentDao{
	
	Connection conn = Database.getConnection();

	@Override
	public Integer addStudent(Student student) {
		Integer row = null;
        try {
            
            java.sql.Date createdDate = new Date(new java.util.Date().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO student(name,dateofbirth,contact,email,create_date,created_by,status) VALUES(?,?,?,?,?,?,1)");
            pstmt.setString(1, student.getName());
            pstmt.setDate(2, new Date(student.getDateOfBirth().getTime()));
            pstmt.setString(3, student.getContact());
            pstmt.setString(4, student.getEmail());
            pstmt.setDate(5, createdDate);
            pstmt.setInt(6, student.getCreatedBy().getId());
           
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer updateStudent(Student student) {
		
		Integer row = null;
        try {
            
            java.sql.Date createdDate = new Date(new java.util.Date().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE student SET name=?,dateofbirth=?,contact=?,email=?,update_date=?,updated_by=? WHERE id=?");
            pstmt.setString(1, student.getName());
            pstmt.setDate(2, new Date(student.getDateOfBirth().getTime()));
            pstmt.setString(3, student.getContact());
            pstmt.setString(4, student.getEmail());
            pstmt.setDate(5, createdDate);
            pstmt.setInt(6, student.getCreatedBy().getId());
            pstmt.setInt(7, student.getId());
           
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer deleteStudent(Integer id) {
		Integer row = null;
        try {
        	
            PreparedStatement pstmt = conn.prepareStatement("UPDATE student SET status=0 WHERE id=?");
            pstmt.setInt(1, id);
           
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer getIdByName(Integer id) {
		Integer sid = null;
		ResultSet rs = null;
        try {
        	
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM student WHERE name=? and status=0");
            pstmt.setInt(1, id);
           
                        
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
				sid = rs.getInt("id");
			}
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return sid;
	}

	@Override
	public Student getStudentById(Integer id) {
		Student student = null;
		ResultSet rs = null;
        try {
        	
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student WHERE id=? and status=0");
            pstmt.setInt(1, id);
           
                        
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setDateOfBirth(rs.getDate("dateofbirth"));
				student.setContact(rs.getString("contact"));
				student.setEmail(rs.getString("email"));
				student.setCreateDate(rs.getDate("create_date"));
				student.setUpdateDate(rs.getDate("update_date"));
				
				Role r1 = new Role();
				r1.setId(rs.getInt("created_by"));
				Role r2 = new Role();
				r1.setId(rs.getInt("updated_by"));
				
				student.setCreatedBy(r1);
				student.setUpdatedBy(r2);
			}
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return student;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> allStudent = new ArrayList<Student>();
		ResultSet rs = null;
        try {
        	
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student WHERE status=0");
           
                        
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setDateOfBirth(rs.getDate("dateofbirth"));
				student.setContact(rs.getString("contact"));
				student.setEmail(rs.getString("email"));
				student.setCreateDate(rs.getDate("create_date"));
				student.setUpdateDate(rs.getDate("update_date"));
				
				Role r1 = new Role();
				r1.setId(rs.getInt("created_by"));
				Role r2 = new Role();
				r1.setId(rs.getInt("updated_by"));
				
				student.setCreatedBy(r1);
				student.setUpdatedBy(r2);
				
				allStudent.add(student);
			}
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return allStudent;
	}

}
