import java.util.Scanner;

public class AAiProjectDevelopment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc. nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            int hours = 0;
            //x*z => n-x*z 10*y*h + x*h
            //(x+y)*h or z ke saath
            int rem = n - x*z;

            if (rem == 0) hours = z;
            else if (rem < 0) hours = Math.ceilDiv(n, x);
            else hours = z + Math.ceilDiv(rem, x+10*y);

            hours = Math.min(hours, Math.ceilDiv(n, x+y));
            System.out.println(hours);
        }
    }
}