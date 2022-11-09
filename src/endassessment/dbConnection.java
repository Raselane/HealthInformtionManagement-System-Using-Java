package endassessment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


 public class dbConnection {
     public static Connection connect (){
        String databaseURL = "jdbc:mysql://localhost:3306/endassessment";
        String user = "root";
        String password = "";
        Connection con = null;
         
         try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(databaseURL, user, password);
           System.out.print("Database connected");
         } catch (ClassNotFoundException ex) {
            System.out.println("Database driver class not found");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("An error occurred. User/password is invalid");
            ex.printStackTrace();
        }
         return con;
    }   
}
