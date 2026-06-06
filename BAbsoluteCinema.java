import java.util.Scanner;

public class BAbsoluteCinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            int maxA = 0;
            long sumB = 0;

            for (int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i=0; i<n; i++) {
                b[i] = sc.nextInt();
            }
            
            for (int i=0; i<n; i++) {
                if (a[i] > b[i]) {
                    int temp = a[i];
                    a[i] =b[i];
                    b[i] = temp;
                }
             }
            
            for (int i=0; i<n; i++) {
                sumB += b[i];
                maxA = Math.max(maxA, a[i]);
            }

            System.out.println(sumB + maxA);
        }
    }
}