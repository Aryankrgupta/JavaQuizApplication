package userOperation;

import java.sql.*;
import java.util.Scanner;

public class FetchOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Roll no : ");
        int rollno = sc.nextInt();

        String url = "jdbc:mysql://localhost:3306/j2ee";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();

            String qry = "select * from student where rollno = "+rollno+"";
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
