import java.util.Scanner;

public class AGamesOnTheTrain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int min = 7;
            int max = 0;

            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }

            System.out.println(max+1-min);
        }
    }
}