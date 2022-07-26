import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    public static List<Product> products = new ArrayList<>();
    // them moi san pham
    public void addProduct(Product product) {
        products.add(product);
    }

    //tim kiem thong tin san pham
    public void findProduct(List<Product> product) {
        System.out.println("nhap vao id san pham can tim kiem");
        Scanner scanner = new Scanner(System.in);
        int code = scanner.nextInt();
        int id = -1;
        for (int i = 0; i < product.size(); i++) {
            id = product.get(i).getId();
            if (id == code){
                System.out.println(product.get(i));
                break;
            }
        }
        if (id != code) System.out.println("khong co san pham trong danh sach");
    }
// ghi danh sach san pham ra file product.dat
    public void writeFile(List<Product> products) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("product.dat");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream obj = new ObjectOutputStream(fileOutputStream);
            obj.writeObject(products);
            obj.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //lay danh sach san pham dang co trong file product.dat
    public List<Product> readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("product.dat");
            try {
                ObjectInputStream obj = new ObjectInputStream(fileInputStream);
                try {
                    Object ob = obj.readObject();
                    List<Product> products = (List<Product>) ob;
                    obj.close();
                    fileInputStream.close();
                    return products;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
