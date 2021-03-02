package daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import models.Role;
import models.User;
import util.Database;

public class UserDaoImpl implements UserDAO{
	
	Connection conn = Database.getConnection();

	@Override
	public Integer addUser(User user) {
		Integer row = null;
        try {
            
            java.sql.Date createdDate = new Date(user.getCreateDate().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user(name,email,password,create_date,created_by,status) VALUES(?,?,?,?,?,1)");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setDate(4, createdDate);
            pstmt.setInt(5, user.getCreatedBy().getId());
           
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer updateUser(User user) {
		Integer row = null;
        try {
            
            java.sql.Date updatedDate = new Date(user.getUpdateDate().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET name=?,email=?,password=?,update_date=?,updated_by where id=?");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setDate(4, updatedDate);
            pstmt.setInt(5, user.getUpdatedBy().getId());
            pstmt.setInt(6, user.getId());
           
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer deleteUser(Integer roleId) {
		Integer row = null;
        try {
            
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET status=0 where id=?");
           
            pstmt.setInt(1, roleId);
           
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public User getUserById(Integer id) {
		User user = null;
		ResultSet rs = null;
        try {
            
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user where id=?");
           
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
            	
            	
            	Role r1 = new Role();
				r1.setId(rs.getInt("created_by"));
				Role r2 = new Role();
				r2.setId(rs.getInt("updated_by"));
            	
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getDate("create_date"));
				user.setUpdateDate(rs.getDate("update_date"));
				user.setCreatedBy(r1);
				user.setUpdatedBy(r2);
				
				
			}
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return user;
	}

	@Override
	public Integer getUserIdByName(String name) {
		Integer id = null;
		ResultSet rs = null;
        try {
            
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user where name=?");
            pstmt.setString(1, name);
            
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
	
	@Override
	public Integer getUserIdByEmailandPass(String email, String pass) {
		Integer id = null;
		ResultSet rs = null;
        try {
            
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user where email=? and password=?");
            pstmt.setString(1, email);
            pstmt.setString(2, pass);
            
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

	@Override
	public List<User> getAllUser() {
		List<User>  allUser = new ArrayList<User>();
		ResultSet rs = null;
        try {
            
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user");
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	
            	
            	Role r1 = new Role();
				r1.setId(rs.getInt("created_by"));
				Role r2 = new Role();
				r2.setId(rs.getInt("updated_by"));
            	
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getDate("create_date"));
				user.setUpdateDate(rs.getDate("update_date"));
				user.setCreatedBy(r1);
				user.setUpdatedBy(r2);
				
				allUser.add(user);
				
			}
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return allUser;
	}

}
