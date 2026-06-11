import java.util.Scanner;

public class CSkiResort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long q = sc.nextLong();

            long arr[] = new long[n+1];

            for (int i=0; i<n; i++) {
                arr[i] = sc.nextLong();
            }
            arr[n] = q+1;
            int idx = 0;
            long ans = 0;
            for (int i=0; i<=n; i++) {
                if (arr[i] <= q) continue;
                int count = i-idx;
                for (int id=k; id<=count; id++) {
                    ans += count-id+1;
                }
                idx = i+1;
            }
            System.out.println(ans);
        }
    }
}