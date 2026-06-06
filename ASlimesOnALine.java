import java.util.Scanner;

public class ASlimesOnALine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            int max = 0;
            int min = 1001;
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }

            System.out.println((max-min+1)/2);
        }
    }
}