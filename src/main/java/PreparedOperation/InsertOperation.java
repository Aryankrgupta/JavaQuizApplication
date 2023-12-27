package PreparedOperation;

import java.sql.*;
import java.util.Scanner;

public class InsertOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Emp Id : ");
        int id = sc.nextInt();

        System.out.println("Enter Emp Name");
        String name = sc.next();

        System.out.println("Enter Emp Designation");
        String designation = sc.next();

        System.out.println("Enter Emp Salary");
        double sal = sc.nextDouble();

        String qry = "insert into emploee values(?, ?, ?, ?)";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "");

            PreparedStatement stat = conn.prepareStatement(qry);

            stat.setInt(1, id);
            stat.setString(2, name);
            stat.setString(3, designation);
            stat.setDouble(4, sal);

            stat.executeUpdate();
            System.out.println("Query Executed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
