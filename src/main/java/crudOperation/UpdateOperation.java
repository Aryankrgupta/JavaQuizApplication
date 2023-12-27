package crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateOperation {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee" ,"root", "");
            String q1 = "update student set marks = 99.33 where rollno = 101";
            Statement s = conn.createStatement();
            s.executeUpdate(q1);
            System.out.println("Update Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
