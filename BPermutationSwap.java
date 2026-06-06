import java.util.Scanner;

public class BPermutationSwap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int diff[] = new int[n];
            int ans = n-1;

            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                diff[i] = Math.abs(arr[i] - i - 1);
                if (diff[i] == 0) continue;
                if (ans == n-1) ans = diff[i];
                ans = gcd(ans, diff[i]);
            }

            System.out.println(ans);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}