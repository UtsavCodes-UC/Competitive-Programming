import java.util.*;

public class AEuclidSequenceAndTwoNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Integer arr[] = new Integer[n];

            for (int i=0; i<n; i++) arr[i] = sc.nextInt();

            Arrays.sort(arr, Collections.reverseOrder());
            boolean ans = true;
            for (int i=0; i<n-2; i++) {
                if (arr[i]%arr[i+1] != arr[i+2]) {
                    ans = false;
                    break;
                }
            }

            if (ans) System.out.println(arr[0] + " " + arr[1]);
            else System.out.println(-1);
        }
    }
}