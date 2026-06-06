import java.util.Scanner;

public class AYoungPhysicist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];
        
        int sumA = 0;
        int sumB = 0;
        int sumC = 0;
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            sumA += a[i];
            sumB += b[i];
            sumC += c[i];
        }

        if (sumA == 0 && sumB == 0 && sumC == 0) System.out.println("YES");
        else System.out.println("NO");

    }
}