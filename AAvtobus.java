import java.util.Scanner;

public class AAvtobus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        while (t-->0) {
            long n = sc.nextLong();
            long temp = n;
            long min=0, max=0;
            //odd
            if ((temp < 4) || temp % 2 == 1) {
                System.out.println(-1);
                continue;
            }

            //min
            while(temp % 6 != 0) {
                temp -= 4;
                min++;
            }
            min += temp/6;

            //max
            temp = n;
            while(temp%4 != 0) {
                temp -= 6;
                max++;
            }
            max += temp/4;

            System.out.println(min + " " + max);

        }
    }
}