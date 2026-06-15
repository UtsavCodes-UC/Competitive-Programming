import java.util.*;

public class BArrayMerging {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();

			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextLong();
			}

			long[] b = new long[(int) n];
			for (int i = 0; i < n; i++) {
				b[i] = sc.nextLong();
			}

			long[] longestSubarrayA = new long[2 * n + 1];
			long[] longestSubarrayB = new long[2 * n + 1];

			long counter = 1;

			for (int i = 1; i < n; i++) {
				if (a[i] == a[i - 1]) {
					counter++;
				} else {
					longestSubarrayA[(int) a[i - 1]] = Math.max(longestSubarrayA[(int) a[i - 1]], counter);
					counter = 1;
				}
			}
			longestSubarrayA[(int) a[(int) (n - 1)]] = Math.max(longestSubarrayA[(int) a[(int) (n - 1)]], counter);

			counter = 1;

			for (int i = 1; i < n; i++) {
				if (b[i] == b[i - 1]) {
					counter++;
				} else {
					longestSubarrayB[(int) b[i - 1]] = Math.max(longestSubarrayB[(int) b[i - 1]], counter);
					counter = 1;
				}
			}
			longestSubarrayB[(int) b[(int) (n - 1)]] = Math.max(longestSubarrayB[(int) b[(int) (n - 1)]], counter);

			long maxFreq = -1;

			for (int i = 1; i <= 2 * n; i++) {
				maxFreq = Math.max(maxFreq, longestSubarrayA[i] + longestSubarrayB[i]);
			}

			System.out.println(maxFreq);
		}
	}
}