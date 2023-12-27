package userOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Marks : ");

        int rollno = sc.nextInt();

        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/j2ee";
        String user = "root";
        String password = "";

        String qry = "delete from student where rollno = "+rollno+" ";
        System.out.println(qry);

        try {
            conn = DriverManager.getConnection(url, user, password);

            Statement s = conn.createStatement();

            s.executeUpdate(qry);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
