import java.util.Scanner;

public class AMarisaStealsReimuSTakeout {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int zeroes = 0, ones = 0, twos = 0;

            for (int i=0; i<n; i++) {
                arr[i] =  sc.nextInt();
                if (arr[i] == 0) zeroes++;
                else if (arr[i] == 1) ones++;
                else twos++;
            }

            int min = Math.min(ones, twos);
            int leftOut = 0;

            if (min == ones)
                leftOut = twos - min;
            else {
                leftOut = ones - min;
            }

            System.out.println(zeroes + min + leftOut/3);
        }
    }
}