import java.util.Scanner;

public class BAnotherSortingProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i=0; i<n; i++) arr[i] = sc.nextInt();
            int maxDiff = 0;

            for (int i=0; i<n-1; i++) {
                if (arr[i] > arr[i+1]) {
                    maxDiff = Math.max(maxDiff, arr[i] - arr[i+1]);
                }
            }

            for (int i=0; i<n-1; i++) {
                if (arr[i] > arr[i+1]) arr[i+1] += maxDiff;
            }
            String isSorted = "YES";
            for (int i=0; i<n-1; i++) {
                if (arr[i] > arr[i+1]) {
                    isSorted = "NO";
                    break;
                }
            }
            System.out.println(isSorted);
        }
    }
}