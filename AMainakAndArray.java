import java.util.Scanner;

public class AMainakAndArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int max = 1;
            int min = 999;
            int maxD = 0;

            int ans = 0;

            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }
            
            for (int i=0; i<n-1; i++) {
                maxD = Math.max(maxD, arr[i] - arr[i+1]);
            }

            System.out.println(Math.max(Math.max(arr[n-1]-min, max-arr[0]), maxD));
        }
    }
}