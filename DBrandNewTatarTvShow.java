import java.util.*;

public class DBrandNewTatarTvShow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            TreeMap<Integer, Integer> freq = new TreeMap<>();

            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            }
            boolean egorWin = false;

            int size = freq.size();

            Integer prev = null;
            for (Map.Entry<Integer, Integer> e : freq.descendingMap().entrySet()) {
                int count = e.getValue();
                int val = e.getKey();
                
                if (count % 2 == 0) {
                    egorWin = true;
                    break;
                }
                else {
                    if (prev != null && (prev - val) <= k) {
                        egorWin = true;
                        break;
                    }
                }
                prev = val;
            }

            if (size == 1) {
                if (freq.get(arr[0]) % 2 == 0) egorWin = true;
            }
            
            if (egorWin) System.out.println("YES"); 
            else System.out.println("NO");
        }
    }
}