import java.util.Arrays;
import java.util.Scanner;

public class DBalancedRound {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-->0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];

            for(int i=0; i<n; i++) arr[i] = sc.nextInt();
            Arrays.sort(arr);

            int ans = n;
            int curr = 1;

            for (int i=1; i<n; i++) {
                if (arr[i] - arr[i-1] > k) {
                    ans = Math.min(ans, n-curr);
                    curr = 0;
                }
                curr++;
            }
            ans = Math.min(ans, n-curr);
            System.out.println(ans);
        }
    }
}