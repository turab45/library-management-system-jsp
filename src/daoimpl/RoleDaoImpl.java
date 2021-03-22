package daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.RoleDao;
import models.Role;
import util.Database;

public class RoleDaoImpl implements RoleDao{

	Connection conn = Database.getConnection();
	
	@Override
	public Integer addRole(Role role) {
		Integer row = null;
		try {
			
			 java.sql.Date createDate = new Date(new java.util.Date().getTime());
			
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO role(role,create_date,created_by,`status`) VALUES(?,?,?,1)");
			pstmt.setString(1, role.getRole());
			pstmt.setDate(2, createDate);
			pstmt.setInt(3, role.getCreatedBy().getId());
			
            
			
			
            row = pstmt.executeUpdate();
			
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer updateRole(Role role) {
		Integer row = null;
		try {
			
			 java.sql.Date updateDate = new Date(new java.util.Date().getTime());
			
			PreparedStatement pstmt = conn.prepareStatement("UPDATE role SET role=?,update_date=?,updated_by=? WHERE `role_id`=?");
			pstmt.setString(1, role.getRole());
			pstmt.setDate(2, updateDate);
			pstmt.setInt(3, role.getUpdatedBy().getId());
			pstmt.setInt(4, role.getId());
			
            
			
			
            row = pstmt.executeUpdate();
			
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer deleteRole(Integer roleId) {
		Integer row = null;
		try {
			
			 java.sql.Date updateDate = new Date(new java.util.Date().getTime());
			
			PreparedStatement pstmt = conn.prepareStatement("UPDATE role SET `status`=0 WHERE `role_id`=?");
			pstmt.setInt(1, roleId);
			
            
			
			
            row = pstmt.executeUpdate();
			
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Role getRoleById(Integer id) {
		Role role = null;
		ResultSet rs = null;
		try {
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM role WHERE `role_id`=? and `status`=1");
			pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
			
            if (rs.next()) {
				role = new Role();
				role.setId(rs.getInt("role_id"));
            	role.setRole(rs.getString("role"));
            	role.setCreateDate(rs.getDate("create_date"));
            	role.setUpdateDate(rs.getDate("update_date"));
            	
            	Role role1 = new Role();
            	role1.setId(rs.getInt("created_by"));
            	Role role2 = new Role();
            	role2.setId(rs.getInt("updated_by"));
            	
            	role.setCreatedBy(role1);
            	role.setUpdatedBy(role2);
			}
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public Integer getRoleIdByName(String name) {
		Integer roleId = null;
		ResultSet rs = null;
		try {
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM role WHERE `role`=? and status>0");
			pstmt.setString(1, name);
            
            rs = pstmt.executeQuery();
			
            if (rs.next()) {
				roleId = rs.getInt("role_id");
			}
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleId;
		
	}

	@Override
	public List<Role> getAllRole() {
		List<Role> allRoles = new ArrayList<Role>();
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM role WHERE status>0");
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	Role role = new Role();
            	role.setId(rs.getInt("role_id"));
            	role.setRole(rs.getString("role"));
            	role.setCreateDate(rs.getDate("create_date"));
            	role.setUpdateDate(rs.getDate("update_date"));
            	
            	Role role1 = new Role();
            	role1.setId(rs.getInt("created_by"));
            	Role role2 = new Role();
            	role2.setId(rs.getInt("updated_by"));
            	
            	role.setCreatedBy(role1);
            	role.setUpdatedBy(role2);
            	
            	allRoles.add(role);
            }
		} catch (Exception ex) {
			 System.out.println("ERROR: "+ex.getMessage());
	         ex.printStackTrace();
		}
		return allRoles;
	}

}
