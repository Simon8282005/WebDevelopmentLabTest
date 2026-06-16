package dao;

/**
 *
 * @author MP2-4
 */

import java.sql.*;
import java.util.ArrayList;
import model.SessionBean;

public class SessionDAO {
    private Connection conn;
    private String databaseName = "jdbc:mysql://localhost:3306/drivesmart_db";
    private String username = "root";
    private String password = "admin";
    
    
    public SessionDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(databaseName, username, password);
        
            System.out.println("Get database connection success. ");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    // Insert method
    public boolean bookSession(SessionBean sessionBean) {
        String sql = "INSERT INTO training_sessions (student_name, branch_location, lesson_type, status) "
                + "VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sessionBean.getStudent_name());
            ps.setString(2, sessionBean.getBranch_location());
            ps.setString(3, sessionBean.getLesson_type());
            ps.setString(4, sessionBean.getStatus());
            
            int row = ps.executeUpdate();
            
            return row > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    // Retrieve method
    public ArrayList<SessionBean> getAllSessions() {
        ArrayList<SessionBean> sessionList = new ArrayList<>();
        String sql = "SELECT * FROM training_sessions ORDER BY branch_location ASC";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int session_id = rs.getInt("session_id");
                String student_name = rs.getString("student_name");
                String branch_location = rs.getString("branch_location");
                String lesson_type = rs.getString("lesson_type");
                String status = rs.getString("status");
                
                sessionList.add(new SessionBean(session_id, student_name, branch_location, lesson_type, status));
            }
            
            return sessionList;
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        return null;
    }
    
    // Delete Method
    public boolean deleteBooking(String id) {
        String sql = "DELETE FROM training_sessions WHERE session_id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            
            int row = ps.executeUpdate();
            
            return row > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
