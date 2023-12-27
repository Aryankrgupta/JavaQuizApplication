package Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private static Connection conn = null;
    static {
        try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertProduct(Product newProduct) {
        int n = 0;

        String qry = "insert into product_info values(?, ?, ?, ?)";
        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setInt(1, newProduct.getProductId());
            stat.setString(2, newProduct.getProductName());
            stat.setDouble(3, newProduct.getProductPrice());
            stat.setString(4, newProduct.getProductType());

            n = stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return n;
    }

    public void deleteProduct(int id) {
        String qry = "delete from product_info where productId = ?";

        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateProductName(int id, String name) {
        String qry = "update product_info set productName = ? where productId = ?";

        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setString(1, name);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProductPrice(int id, double price) {
        String qry = "update product_info set productPrice = ? where productId = ?";

        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setDouble(1, price);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProductType(int id, String type) {
        String qry = "update product_info set productType = ? where productId = ?";

        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setString(1, type);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAllDetail(String productName, double productPrice, String productType) {
        String qry = "update product_info set productName = ?, productPrice = ?, productType = ? where productId = ?";

        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setString(2, productName);
            stat.setDouble(3, productPrice);
            stat.setString(4, productType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Product> displayProduct() {
        String qry = "select * from product_info";
        List<Product> list = new ArrayList<>();

        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(qry);

            while (rs.next()) {
                int id  = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                String type = rs.getString(4);

                Product pro = new Product(id, name, price, type);

                list.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Product displayProductById(int id) {
        String qry = "select * from product_info where productId = ?";
        Product product = new Product();
        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                String type = rs.getString(4);

                product = new Product(id, name, price, type);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public List<Product> filterByPrice(int lower, int higher) {
        String qry = "select * from product_info where productPrice between ? and ?";
        List<Product> list = new ArrayList<>();
        try {
           PreparedStatement stat = conn.prepareStatement(qry);
            stat.setInt(1, lower);
            stat.setInt(2, higher);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Product> filterByCategory(String cate) {
        String qry = "select * from product_info where productType = ?";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setString(1, cate);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                String type = rs.getString(4);

                Product product = new Product(id, name, price, type);
                list.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
