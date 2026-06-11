import java.util.Arrays;
import java.util.Scanner;

public class BOlyaAndGameWithArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long sum = 0;
            long min = Long.MAX_VALUE;
            long minS = Long.MAX_VALUE;
            for (int i=0; i<n; i++) {
                int m = sc.nextInt();
                long arr[] = new long[m];
                for (int j=0; j<m; j++) {
                    arr[j] = sc.nextLong();
                }
                Arrays.sort(arr);
                min = Math.min(min, arr[0]);
                minS = Math.min(minS, arr[1]);
                sum += arr[1];
            }

            sum += min - minS;
            System.out.println(sum);
        }
    }
}