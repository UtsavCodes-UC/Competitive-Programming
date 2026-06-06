import java.util.Scanner;

public class BComparisonString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            int count = 1;
            int ans = 0;
            for (int i=1; i<n; i++) {
                if (str.charAt(i) != str.charAt(i-1)) {
                    ans = Math.max(ans, count);
                    count = 0;
                }
                count++;
            }

            ans = Math.max(ans, count);
            System.out.println(ans+1);

        }
    }
}