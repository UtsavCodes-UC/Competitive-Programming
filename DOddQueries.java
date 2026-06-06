import java.util.Scanner;

public class DOddQueries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int arr[] = new int[n];
            int prefixSum[] = new int[n+1];
            int sum = 0;

            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            prefixSum[0] = 0;
            for (int i=1; i<=n; i++) {
                prefixSum[i] = prefixSum[i-1] + arr[i-1];
            }

            for (int i=0; i<q; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int k = sc.nextInt();

                int currSum = sum;
                currSum -= prefixSum[r] - prefixSum[l-1];
                currSum += k*(r-l+1);
                if (currSum % 2 == 0) System.out.println("NO");
                else System.out.println("YES");
            }
        }
    }
}