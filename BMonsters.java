import java.util.*;

public class BMonsters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long arr[][] = new long[n][2];
            for (int i=0; i<n; i++) {
                arr[i][0] = (sc.nextLong() % k);
                if (arr[i][0] == 0) arr[i][0] = k;
                arr[i][1] = i+1; 
            }
            Arrays.sort(arr, (a, b) -> {
                if (a[0] == b[0]) return Long.compare(a[1], b[1]);
                return Long.compare(b[0], a[0]);
            });

            for (int i=0; i<n; i++) {
                System.out.print(arr[i][1] + " ");
            }
            System.out.println();
        }
    }
}