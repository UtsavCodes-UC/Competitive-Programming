import java.util.Scanner;

public class DDeletiveEditing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-->0) {
            String s = sc.next();
            String t = sc.next();

            int freq[] = new int[26];

            for (int i=0; i<t.length(); i++) {
                freq[t.charAt(i) - 'A']++;
            }
            StringBuilder finalStr = new StringBuilder();
            for(int i=s.length()-1; i>=0; i--) {
                if (freq[s.charAt(i) - 'A'] > 0) {
                    freq[s.charAt(i)-'A']--;
                    finalStr.append(s.charAt(i));
                }
            }

            if (finalStr.reverse().toString().equals(t)) {
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}