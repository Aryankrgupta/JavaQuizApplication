package PreparedOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter EmpId : ");
        int id = sc.nextInt();

        System.out.println("Enter Emp Name");
        String name = sc.next();

        System.out.println("Enter Emp Designation");
        String designation = sc.next();

        System.out.println("Enter Emp Salary");
        double sal = sc.nextDouble();

        String qry = "update emploee set empDesignation = ?, empName = ?, empSal = ? where empId = ?";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=");

            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setString(1, designation);
            stat.setString(2, name);
            stat.setDouble(3, sal);
            stat.setInt(4, id);

            stat.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
