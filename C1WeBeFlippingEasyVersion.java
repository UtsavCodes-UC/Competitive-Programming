import java.util.Scanner;

public class C1WeBeFlippingEasyVersion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            int j = 0;
            int ans[] = new int[n];
            for (int i=n-1; i>=0; i--) {
                if (arr[i] * Math.pow(-1, j) > 0) {
                    ans[j] = i+1;
                    j++;
                } 
            }
            System.out.println(j);
            for (int i=0; i<j; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}