package crudOperation;

import java.sql.*;

public class FetchOperation {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "");

            String qry = "select * from student";


            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(qry);

            while (rs.next()) {
                System.out.println(rs.getInt("rollno") + "\t" + rs.getString("name") + "\t" + rs.getDouble("marks") );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
