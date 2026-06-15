import java.util.Scanner;

public class COmskProgrammers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x = sc.nextLong();

            long max = Math.max(a, b);
            long min = Math.min(a, b);

            long op = 0;
            long minOp = max-min;
            while (max != 0 || min!=0) {
                if (max > min) {
                    max /= x;
                    op++;
                }
                else {
                    min /= x;
                    op++;
                }
                long diff = Math.abs(max-min);
                minOp = Math.min(minOp, op+diff);
            }
            System.out.println(minOp);
        }
    }
}