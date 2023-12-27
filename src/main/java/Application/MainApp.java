package Application;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Service service = new Service();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Select Option : ");
        System.out.println("1. Insert Product :");
        System.out.println("2. Update Product : ");
        System.out.println("3. Remove Product : ");
        System.out.println("4. Display Product : ");
        System.out.println("5. Filter product : ");
        System.out.println("6. Exit");

        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                insertProduct();
                break;
            case 2:
                updateProduct();
                break;
            case 3:
                deleteProduct();
                break;
            case 4:
                displayProduct();
                break;
            case 5:
                filter();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ch);
        }
        main(args);
    }

    private static void filter() {
        System.out.println("Select Option : ");
        System.out.println("1. Filter By price ");
        System.out.println("2. Filter By Category ");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                System.out.println("Enter Lower Price :");
                int lower = sc.nextInt();
                System.out.println("Enter higher price : ");
                int higher = sc.nextInt();
                List<Product> product = service.filterByPrice(lower, higher);
                for(Product p : product) {
                    System.out.println(p.getProductId() + " \t " + p.getProductName() + " \t " + p.getProductPrice() + " \t " + p.getProductType());
                }
                break;
            case 2:
                System.out.println("Enter Category : ");
                String cate = sc.next();
                List<Product> productList = service.filterByCategory(cate);
                for(Product p : productList) {
                    System.out.println(p.getProductId() + " \t " + p.getProductName() + " \t " + p.getProductPrice() + " \t " + p.getProductType());
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ch);
        }
    }


    private static void deleteProduct() {
        System.out.println("Enter Product Id : ");
        int ch = sc.nextInt();
        service.deleteProduct(ch);
        System.out.println("Product Deleted!!!");
    }

    private static void displayProduct() {
        System.out.println("Select Option : ");
        System.out.println("1. Do you wanted to Display Product By Id");
        System.out.println("2. Display All Product ");
        int ch = sc.nextInt();
        if (ch == 1) {
            displayProductById();
        } else if (ch == 2) {
        List<Product> product = service.displayProduct();
        System.out.println("Id \t\t Name \t\t Price \t\t Type");
        System.out.println("---------------------------------------------------");
        for (Product p : product) {
            System.out.println(p.getProductId() + " \t " +p.getProductName() + " \t " + p.getProductPrice() + " \t " + p.getProductType());
        }
        }
    }
    private static void displayProductById() {
        System.out.println("Enter Product Id");
        int id = sc.nextInt();
        Product product = service.displayProductById(id);
        System.out.println("Id \t\t Name \t\t Price \t\t Type");
        System.out.println("---------------------------------------------------");
        System.out.println(product.getProductId() + " \t " +product.getProductName() + " \t " + product.getProductPrice() + " \t " + product.getProductType());
        
    }

    private static void updateProduct() {
        System.out.println("Enter Product Id : ");
        int id = sc.nextInt();
        System.out.println("Select Update Option : ");
        System.out.println("1. Update Product Name \n2. Update Product Price \n3. Update product Type \n4.Update All Details ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter Product Name : ");
                String name = sc.next();
                service.updateProductName(id, name);
                break;
            case 2:
                System.out.println("Enter Product Price : ");
                double price = sc.nextDouble();
                service.updateProductPrice(id, price);
                break;
            case 3:
                System.out.println("Enter Product Type : ");
                String type = sc.next();
                service.updateProductType(id, type);
                break;
            case 4:
                System.out.print("ENTER PRODUCT NAME :");
                String productName=sc.next();
                System.out.print("ENTER PRODUCT PRICE :");
                double productPrice= sc.nextDouble();
                System.out.print("ENTER PRODUCT TYPE :");
                String productType = sc.next();

                service.updateAllDetail(productName, productPrice, productType);

            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }

    }

    public static void insertProduct() {
        System.out.print("ENTER PRODUCT ID :");
        int productId= sc.nextInt();
        System.out.print("ENTER PRODUCT NAME :");
        String productName=sc.next();
        System.out.print("ENTER PRODUCT PRICE :");
        double productPrice= sc.nextDouble();
        System.out.print("ENTER PRODUCT TYPE :");
        String productType = sc.next();

        Product pro = new Product(productId, productName, productPrice, productType);
        int n = service.insertProduct(pro);
        System.out.println(n + "Record Added");
    }
}
