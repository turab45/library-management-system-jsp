package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import dao.UserDAO;
import models.User;
import util.Database;

public class UserDaoImpl implements UserDAO{
	
	Connection conn = Database.getConnection();

	@Override
	public Integer addUser(User user) {
		Integer row = null;
        try {
            
            //java.sql.Date createdDate = new Date(user.getCreatedDate().getTime());
            
//            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user(name,email,password,create_date,created_by) VALUES(?,?,?,?,?)");
//            pstmt.setString(1, user);
//            pstmt.setString(2, user.getPassword());
//            pstmt.setInt(3, user.getRole().getRoleId());
//            pstmt.setString(4, user.getEmail());
//            pstmt.setString(5, user.getContact());
//            pstmt.setString(6, user.getAddress());
//            pstmt.setDate(7, createdDate);
//            pstmt.setInt(8, user.getCreatedBy());
//            pstmt.setInt(9, 1);
//            
            
//            row = pstmt.executeUpdate();
//            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer updateUser(User role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteUser(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getUserIdByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
