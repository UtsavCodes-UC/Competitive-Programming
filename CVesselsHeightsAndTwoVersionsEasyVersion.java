import java.util.Scanner;

public class CVesselsHeightsAndTwoVersionsEasyVersion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long arr[] = new long[n];

            for (int i=0; i<n; i++) {
                arr[i]  = sc.nextLong();
            }

            for (int i=0; i<n; i++) {
                long maxRight = 0;
                for (int j=0; j<n; j++) {
                    maxRight = Math.max(maxRight, arr[(i+j)%n]);
                }
                long maxLeft = 0;
                for (int j=0; j<n; j++) {
                    maxLeft = Math.max(maxLeft, arr[(i-j+n)%n]);
                }
                long water = Math.min(maxLeft, maxRight);
                System.out.print(water + " ");
            }
            System.out.println();
        }
    }
}