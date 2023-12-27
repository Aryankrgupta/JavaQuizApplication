package PreparedOperation;

import java.sql.*;
import java.util.Scanner;

public class DeleteOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter EmpId : ");
        int id = sc.nextInt();

        String qry = "delete from emploee where empId = ? ";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=");
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
