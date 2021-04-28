package Optional;

import java.io.*;
import java.util.Scanner;

public class Check {
    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        int count = 0;
        is = new FileInputStream(source);
        os = new FileOutputStream(dest);
        byte[] buffer = new byte[1];

        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
            count++;
        }

        is.close();
        os.close();
        System.out.println(count);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập file nguồn");
        String source = sc.nextLine();
        System.out.println("Nhập file đích");
        String target = sc.nextLine();
        File sourceFile = new File(source);
        File targetFile = new File(target);

        if (targetFile.exists()) {
            System.err.println("File đã tồn tại");
            System.out.println("Nhập tên tệp mới");
            targetFile = new File(sc.nextLine());
        }

        try {
            copyFileUsingStream(sourceFile, targetFile);
        } catch (IOException e) {
            System.err.println("Tệp không tồn tại");
        }
    }
}
