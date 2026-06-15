import java.util.Arrays;
import java.util.Scanner;

public class BTatarTvShow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String str = sc.next();
            int freq[] = new int[k];
            Arrays.fill(freq, 0);
            boolean ans = true;
            for (int i=0; i<n; i++) {
                if (str.charAt(i) == '1') freq[i%k]++;
            }

            for (int i=0; i<k; i++) {
                if(freq[i] % 2 != 0) {
                    ans = false;
                    break;
                }
            }
            
            if (ans) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}