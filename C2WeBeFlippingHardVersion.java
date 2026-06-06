import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C2WeBeFlippingHardVersion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            long[] a = new long[n];
            long[] pre = new long[n];
            long[] suff = new long[n+1];
            suff[n] = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                if (i==0) pre[i] = Math.abs(a[i]);
                else pre[i] = pre[i-1] + Math.abs(a[i]);
            }

            for (int i=n-1; i>=0; i--) {
                suff[i] = suff[i+1] + a[i];
            }

            ArrayList<Integer> ops = new ArrayList<>();
            int idx = -1;
            long best = suff[0];

            for (int i=1; i<n; i++) {
                if (a[i] < 0) continue;
                long sum = pre[i-1] + suff[i+1] - a[i];
                if (sum > best) {
                    best = sum;
                    idx = i;
                }
            }
            if (idx == -1) {
                System.out.println(0);
                System.out.println();
                continue;
            }

            int j=0;
            for (int i=idx-1; i>=0; i--) {
                if (a[i] * Math.pow(-1, j) > 0) {
                    ops.add(i+1);
                    j++;
                } 
            }
            ops.add(idx+1);

            System.out.println(ops.size());
            for (int x : ops) {
                System.out.print(x + " ");
            }

            System.out.println();
        }
    }
}