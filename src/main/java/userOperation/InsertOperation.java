package userOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter RollNo : ");
        int rollno = sc.nextInt();

        System.out.println("Enter Name : ");
        String name = sc.next();

        System.out.println("Enter Marks : ");
        double marks = sc.nextDouble();

        String qry = "insert into student values("+rollno+", '"+name+"', "+marks+")";

        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/j2ee";
        String user = "root";
        String password = "";

        try {
            conn = DriverManager.getConnection(url, user, password);

            Statement s = conn.createStatement();

            s.executeUpdate(qry);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
