package productManage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        List<Product> listProduct = new LinkedList<>();
        while (true){
            System.out.println("=====PRODUCT MANAGE======");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Sửa thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("6. Tìm kiếm sản phẩm");
            System.out.println("7. Quit");
            System.out.println("Nhập chức năng :");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                  display(listProduct);
                  break;
                case 2:
                    createProduct(listProduct,scanner);
                    break;
                case 3:
                    display(listProduct);
                    updateProduct(listProduct);
                    break;
                case 4:
                    deleteProduct(listProduct);
                    break;
                case 5:
sortPrice(listProduct);
break;
                case 6:
                    search(listProduct);
                    break;
                case 7:
System.exit(0);
                case 8:
                    System.out.println("No choice");
            }
        }
    }
    public static void display(List<Product> listProduct){
if (listProduct.size()== 0){
    System.out.println("Không có sản phẩm");
} else {
    for (int i = 0; i < listProduct.size(); i++) {
        System.out.println(listProduct.get(i));
    }
}
    }
    public static void createProduct (List<Product> listProduct, Scanner scanner){
        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        int price = Integer.parseInt(scanner.nextLine());
        int idMax = 0;
        boolean checkNull = false;
        boolean check = false;
if (listProduct.size() == 0){
    idMax = 0;
} else {
    idMax = listProduct.size();
}
        Product product = new Product(idMax,name,price);
listProduct.add(product);
        System.out.println("Thêm mới thành công");
    }
    public static void updateProduct(List<Product> listProduct){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id cần sửa :");
        int idUpdate = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên mới :");
        String newName = scanner.nextLine();
        System.out.println("Nhập giá mới :");
        int newPrice = Integer.parseInt(scanner.nextLine());
        Product product = new Product(idUpdate,newName,newPrice);
        listProduct.remove(idUpdate);
        listProduct.add(idUpdate,product);
    }
    public static void deleteProduct(List<Product> listProduct){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id cần xóa :");
        int idDelete = Integer.parseInt(scanner.nextLine());
        listProduct.remove(idDelete);
    }
    public static void search(List<Product> listProduct){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm cần tìm kiếm :");
        String searchName = scanner.nextLine();
        Product product = new Product();
        boolean check = false;
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getName().equals(searchName)){
                check = true;
                product = listProduct.get(i);
            }
        }
        if (check){
            System.out.println(product.toString());
        } else {
            System.out.println("không tìm thấy sản phẩm");
        }

    }
    public static void sortPrice(List<Product> listProduct){
        PriceComparator priceComparator = new PriceComparator();
        Collections.sort(listProduct,priceComparator);
    }
}