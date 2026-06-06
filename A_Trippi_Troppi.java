import java.util.Scanner;

public class A_Trippi_Troppi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            for (int i=1; i<str.length(); i++) {
                if (str.charAt(i-1) == ' ') sb.append(str.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }
}