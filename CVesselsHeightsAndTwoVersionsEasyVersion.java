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

            for (int k=0; k<n; k++) {
                long sum = 0;
                sum += arr[(k-1)%n] + arr[k];
                if (k>=2) {
                    int i=k-2;
                    long maxi = arr[i+1];
                    while(i>=0) {
                        maxi = Math.max(maxi, arr[i]);
                        sum += maxi;
                        i--;
                    }
                }

                int i=k+2;
                long maxi = arr[k];
            }

        }
    }
}