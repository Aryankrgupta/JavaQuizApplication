package crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertOperation {
    public static void main(String[] args) {
        Connection conn = null;


        String url = "jdbc:mysql://localhost:3306/j2ee";
        try {
            conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Connected");

            String query = "INSERT INTO STUDENT VALUES(103, 'HAWK_EYE', 72.33)";
            Statement s = conn.createStatement();
            s.executeUpdate(query);
            System.out.println("Query Executed Successfully");
        } catch (SQLException s) {
            System.out.println(s);
        }
    }
}
