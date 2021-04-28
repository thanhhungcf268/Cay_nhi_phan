import java.util.Scanner;

public class LazyPrimeFactorization implements Runnable{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        System.out.print("Nhập n = ");
        int n = 10;
        System.out.printf("%d số nguyên tố đầu tiên là: \n", n);
        int dem = 0; // đếm số số nguyên tố
        int i = 2;   // tìm số nguyên tố bắt dầu từ số 2
        while (dem < n) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
                dem++;
            }
            i++;
        }
        long stop = System.currentTimeMillis();
        System.out.println((stop-start));

    }
    public  boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
