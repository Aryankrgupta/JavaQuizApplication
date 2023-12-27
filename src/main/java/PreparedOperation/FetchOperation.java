package PreparedOperation;

import java.sql.*;
import java.util.Scanner;

public class FetchOperation {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Lower Salary : ");
        double lSal = sc.nextDouble();
        System.out.println("Enter Higher Salary : ");
        double hSal = sc.nextDouble();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=");



        String qry = "select * from emploee where empSal between ? and ?";

        PreparedStatement st = conn.prepareStatement(qry);

        st.setDouble(1, lSal);
        st.setDouble(2, hSal);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt(1)+ "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));
        }


    }
}
