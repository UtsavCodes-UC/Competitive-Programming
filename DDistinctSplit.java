import java.util.Arrays;
import java.util.Scanner;

public class DDistinctSplit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            int freq[] = new int[26];
            int distinctsLeft[] = new int[n];
            int distinctsRight[] = new int[n];
            int distincts = 0;
            Arrays.fill(freq, 0);

            for (int i=0; i<n; i++) {
                if (freq[str.charAt(i) - 'a'] == 0) {
                    distincts++;
                }
                distinctsLeft[i] = distincts;
                freq[str.charAt(i) - 'a']++;
            }
            distincts = 0;
            Arrays.fill(freq, 0);
            for (int i=n-1; i>=0; i--) {
                distinctsRight[i] = distincts;
                if (freq[str.charAt(i) - 'a'] == 0) {
                    distincts++;
                }
                freq[str.charAt(i) - 'a']++;
            }
            int max = 0;
            for (int i=0; i<n; i++) {
                max = Math.max(max, distinctsLeft[i] + distinctsRight[i]);
            }
            System.out.println(max);
        }
    }
}