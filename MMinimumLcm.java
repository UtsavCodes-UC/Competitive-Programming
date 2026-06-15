import java.util.Scanner;

public class MMinimumLcm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            
            //a+b=n LCM(a,b)=b => a + a*x = n => a(x+1) = n => n%a = 0
            //b = a*x where x is smallest so b=LCM is min

            long a=1, b=n-1;
            for(long i=2; i*i<=n; i++) {
                if (n % i == 0) {
                    a = n/i;
                    b = n-a;
                    break;
                }
            }
            System.out.println(a + " " + b);
        }
    }
}