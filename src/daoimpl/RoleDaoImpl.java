package daoimpl;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteRole(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role getRoleById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getRoleIdByName(String name) {
		// TODO Auto-generated method stub
		return null;
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
