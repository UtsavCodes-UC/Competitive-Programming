import java.util.Scanner;

public class BAnotherSortingProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i=0; i<n; i++) arr[i] = sc.nextInt();
            int maxi = arr[n-1];
            int count = 0;

            for (int i=n-2; i>=0; i--) {
                if (arr[i] >= maxi) {
                    count++;
                    maxi = arr[i];
                }
            }

            if (count > 1) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}