import java.util.Scanner;

public class BLongestDivisorsInterval {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();

            for (long i=1; i-1<=Math.sqrt(n); i++) {
                if (n%i != 0) {
                    System.out.println(i-1);
                    break;
                }
            }
        }
    }
}