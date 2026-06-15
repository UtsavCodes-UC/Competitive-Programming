import java.util.Scanner;
import java.util.StringTokenizer;

public class BPileShuffling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String str = "";
            long a[] = new long[n];
            long b[] = new long[n];
            long c[] = new long[n];
            long d[] = new long[n];

            long ops = 0;
            sc.nextLine();
            for (int i=0; i<n; i++) {
                str = sc.nextLine();
                StringTokenizer st = new StringTokenizer(str, " ");
                a[i] = Long.parseLong(st.nextToken());
                b[i] = Long.parseLong(st.nextToken());
                c[i] = Long.parseLong(st.nextToken());
                d[i] = Long.parseLong(st.nextToken());
            }

            long diff1, diff2;

            for (int i=0; i<n; i++) {
                diff1 = a[i] - c[i];
                diff2 = b[i] - d[i];

                if (c[i] < a[i]) ops += diff1;
                if (d[i] < b[i]) ops += (long) (Math.min(a[i], c[i])) + (diff2);
            }
            System.out.println(ops);
        }
    }
}