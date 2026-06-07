import java.util.Scanner;

public class CRaspberries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];
            int evens = 0;

            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] % 2 == 0) evens++;
            }

            int ans = 10;
            
            for(int i=0; i<n; i++) {
                if (arr[i] % k == 0) ans = 0;
                else if (arr[i] == 1) ans = Math.min(ans, k-1);
                else if (arr[i] > k) ans = Math.min(ans, k-(arr[i]%k));
                else ans = Math.min(ans, k-arr[i]);
            }

            if (k==4) {
                if (evens >= 2) ans = 0;
                else if (evens == 1) ans = Math.min(ans, 1);
                else ans = Math.min(ans, 2);
            }
            System.out.println(ans);
        }
    }
}