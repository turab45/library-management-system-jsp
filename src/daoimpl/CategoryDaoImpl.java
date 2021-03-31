package daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import models.Category;
import models.Role;
import util.Database;

public class CategoryDaoImpl implements CategoryDao{
	
	Connection conn = Database.getConnection();

	@Override
	public Integer addCategory(Category category) {
		Integer row = null;
        try {
            
            java.sql.Date createdDate = new Date(new java.util.Date().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO category(category,create_date,created_by,status) VALUES(?,?,?,1)");
            pstmt.setString(1, category.getCategory());
            pstmt.setDate(2, createdDate);
            pstmt.setInt(3, category.getCreatedBy().getId());
           
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer updateCategory(Category category) {
		Integer row = null;
        try {
            
            java.sql.Date updateDate = new Date(new java.util.Date().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE category SET category=?,update_date=?,updated_by=? WHERE id=?");
            pstmt.setString(1, category.getCategory());
            pstmt.setDate(2, updateDate);
            pstmt.setInt(3, category.getUpdatedBy().getId());
            pstmt.setInt(4, category.getId());
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer deleteCategory(Integer id) {
		Integer row = null;
        try {
            
            java.sql.Date updateDate = new Date(new java.util.Date().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE category SET status=0 WHERE id=?");
            pstmt.setInt(1, id);
                        
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
	}

	@Override
	public Integer getIdByName(String name) {
		Integer id = null;
		ResultSet rs = null;
        try {
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM category WHERE category=? and status > 0");
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
	public Category getCategoryById(Integer id) {
		Category category = null;
		ResultSet rs = null;
        if (id != null) {
        	try {
                
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM category WHERE id=? and status > 0");
                pstmt.setInt(1, id);
                            
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
    				category = new Category();
    				category.setId(rs.getInt("id"));
    				category.setCategory(rs.getString("category"));
    				category.setCreateDate(rs.getDate("create_date"));
    				category.setUpdateDate(rs.getDate("update_date"));
    				
    				Role r1 = new Role();
    				r1.setId(rs.getInt("created_by"));
    				Role r2 = new Role();
    				r2.setId(rs.getInt("updated_by"));
    				
    				category.setCreatedBy(r1);
    				category.setUpdatedBy(r2);
    				
    				System.out.println("Created By ID From DB: "+rs.getInt("created_by"));
    				System.out.println("Created By ID From DB: "+rs.getInt("updated_by"));
    			}
                
            } catch (Exception ex) {
                System.out.println("ERROR: "+ex.getMessage());
                ex.printStackTrace();
            }
		}
        return category;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> allCategory = new ArrayList<Category>();
		ResultSet rs = null;
        try {
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM category WHERE status = 1");
                        
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setCategory(rs.getString("category"));
				category.setCreateDate(rs.getDate("create_date"));
				category.setUpdateDate(rs.getDate("update_date"));
				
				Role r1 = new Role();
				r1.setId(rs.getInt("created_by"));
				Role r2 = new Role();
				r2.setId(rs.getInt("updated_by"));
				
				category.setCreatedBy(r1);
				category.setUpdatedBy(r2);
				
				allCategory.add(category);
			}
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return allCategory;
	}

}
