package BaiTap;

import Practice2.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeTo(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String path) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public static void addProduct(String path, List<Product> products, Product a) {
        writeTo(path, products);
        readDataFromFile(path);
        products.add(a);
        writeTo(path, products);
        readDataFromFile(path);
    }

    public static void displayFile() {
        List<Product> a = readDataFromFile("FileBinary\\data\\products.txt");
        for (Product x : a) {
            System.out.println(x);
        }
    }

    public static void removeProduct(String path, List<Product> products, Product a){
        writeTo(path, products);
        readDataFromFile(path);
        products.remove(a);
        writeTo(path, products);
        readDataFromFile(path);
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "1", "1", 1, "1"));
        products.add(new Product(2, "1", "1", 1, "1"));
        products.add(new Product(3, "1", "1", 1, "1"));
        products.add(new Product(4, "1", "1", 1, "1"));
        products.add(new Product(5, "1", "1", 1, "1"));

        writeTo("FileBinary\\data\\products.txt", products);
        displayFile();
        System.out.println();
        Product product = new Product(6, "1", "1", 1, "1");
        addProduct("FileBinary\\data\\products.txt", products, product);
        displayFile();
        System.out.println();
        Product product1 = new Product(7, "1", "1", 1, "1");
        addProduct("FileBinary\\data\\products.txt", products, product1);
        displayFile();
        System.out.println();
        removeProduct("FileBinary\\data\\products.txt", products, product);
        displayFile();
    }
}
