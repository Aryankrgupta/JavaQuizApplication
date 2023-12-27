package userOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Rollno Do you wanted to update : ");
        int rollno = sc.nextInt();

        System.out.println("Enter New Name : ");
        String name = sc.next();

        System.out.println("Enter New Marks : ");
        double marks = sc.nextDouble();

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/j2ee";
        String user = "root";
        String password = "";

        String qry = "update student set name = '"+name+"', marks = "+marks+" where rollno = "+rollno+"";

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
            Statement st = conn.createStatement();

            st.executeUpdate(qry);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
