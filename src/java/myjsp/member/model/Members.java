
package myjsp.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Members {
    private Connection CreateConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String conn = "jdbc:mysql://157.179.2.79/myjava";
        Connection connect = DriverManager.getConnection(conn, "root", "1234");
        return connect;
    }
    
    public boolean canLogin(Member m){
        String query = "SELECT * FROM member "
                            + "WHERE username = ? AND password = ?";
        try(Connection connect = CreateConnection();){
            PreparedStatement stmt = connect.prepareStatement(query);
            
            stmt.setString(1, m.getUsername());
            stmt.setString(2, m.getPassword());
            
            ResultSet rs = stmt.executeQuery();
            System.out.println(stmt);
            return rs.next();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
