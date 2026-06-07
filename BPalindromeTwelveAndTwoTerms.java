import java.util.Scanner;

public class BPalindromeTwelveAndTwoTerms {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();

            long rem = n % 12;
            long quot = n/12;

            if (rem == 10) {
                if (quot == 0) {
                    System.out.println(-1);
                    continue;
                }
                rem = 22;
                quot--;
            }

            long b = quot * 12;

            System.out.println(rem + " " + b);
        }
    }
}