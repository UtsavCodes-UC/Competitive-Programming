import java.util.Scanner;

public class BMakeItIncreasing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = new long[n];

            for (int i=0; i<n; i++) {
                arr[i] = sc.nextLong();
            }
            int op = 0;
            boolean flag = false;
            for (int i=n-2; i>=0; i--) {
                if (arr[i+1] == 0) {
                    flag = true;
                    System.out.println(-1);
                    break;
                }
                while(arr[i] >= arr[i+1]) {
                    arr[i] /= 2;
                    op++;
                }
            }
            if(!flag) System.out.println(op);
        }

    }
}