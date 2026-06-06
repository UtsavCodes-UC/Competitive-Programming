import java.util.Scanner;

public class B_Bobritto_Bandito {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            int newl = l;

            int newr = l + m;

            if (newr < 0) {
                newl = l - newr;
                newr = 0;
            }

            System.out.println(newl + " " + newr);
        }
    }
}