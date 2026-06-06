import java.util.Scanner;

public class BSwapAndDelete {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String str = sc.next();
            int n = str.length();
            int count1 = 0;
            int count0 = 0;
            for (int i=0; i<n; i++) {
                if (str.charAt(i) == '1') count1++;
                else count0++;
            }
            int idx = -1;
            for (int i=0; i<n; i++) {
                if (str.charAt(i) == '1') count0--;
                else count1--;
                if (count0 < 0 || count1<0) {
                    idx = i;
                    break;
                }
            }
            if (idx == -1) System.out.println(0);
            else System.out.println(n-idx);
        }
    }
}