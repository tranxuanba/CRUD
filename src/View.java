import java.util.List;
import java.util.Scanner;

public class View {
    private static List<Product> products = Manager.products;

    public static void main(String[] args) {
        Product pr1 = new Product(1, "ba", "VN", 120);
        Product pr2 = new Product(2, "bon", "VN", 150);
        Product pr3 = new Product(3, "nam", "VN", 160);
        products.add(pr1);
        products.add(pr2);
        products.add(pr3);
        Manager manager = new Manager();
        // in ra danh sach san pham sau khi them san pham
//        manager.addProduct(newProduct());
        //System.out.println(products);
        // in ra san pham can tim kiem
       // manager.findProduct(products);
        // viet danh sach san pham vao file
        manager.writeFile(products);
        // doc danh sach san pham trong file
        manager.readFile();
      //  System.out.println(products);

    }

    // them moi thong tin san pham
    public static Product newProduct() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("nhap vao thong tin id san pham");
        int id = scanner.nextInt();
        product.setId(id);
        System.out.println("nhap vao ten san pham");
        String name = scanner1.nextLine();
        product.setName(name);
        System.out.println("nhap vao hang san xuat san pham");
        String manufacturer = scanner1.nextLine();
        product.setManufacturer(manufacturer);
        System.out.println("nhap vao gia san pham");
        int price = scanner.nextInt();
        product.setPrice(price);
        return product;
    }
}
