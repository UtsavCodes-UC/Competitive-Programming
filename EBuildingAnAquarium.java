import java.io.*;
import java.util.*;

public class EBuildingAnAquarium {

    static class FastScanner {
        private final BufferedInputStream in =
                new BufferedInputStream(System.in);

        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;

            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }

        long nextLong() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;

            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }

        String next() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            StringBuilder sb = new StringBuilder();

            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }

            return sb.toString();
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    static class Pair {
        long val;
        int idx;

        Pair(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    // Utility Functions

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
			long n = fs.nextLong(); // Number of columns
			long x = fs.nextLong(); // Maximum water units available
			List<Long> heights = new ArrayList<>(); // List to store the heights of the coral columns
			for (int i = 0; i < n; i++) { // Input the heights of the columns
				heights.add(fs.nextLong());
			}
			long si = 1, ei = (long) 1e12, ans = -1; // Initialize binary search bounds and answer
			while (si <= ei) { // Perform binary search
				long mid = si + (ei - si) / 2; // Calculate mid-point
				if (check(mid, heights, x)) { // Check if 'mid' height is feasible
					ans = mid; // Update answer
					si = mid + 1; // Try for a higher height
				} else {
					ei = mid - 1; // Try for a lower height
				}
			}
			System.out.println(ans); // Output the maximum possible height
		}
    }

    private static boolean check(long mid, List<Long> heights, long x) {
		long units = 0; // Initialize water units needed
		int n = heights.size(); // Get the number of columns
		for (int i = 0; i < n; i++) { // Iterate over each column
			if (heights.get(i) < mid) { // If the column is shorter than 'mid'
				units += (mid - heights.get(i)); // Calculate the water needed to fill it to 'mid'
			}
		}
		return units <= x; // Return true if the required water is within the limit
	}
}