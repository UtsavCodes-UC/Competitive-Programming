import java.io.*;
import java.util.*;

public class CUnstableElements {

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

            int n = fs.nextInt();
            int k = fs.nextInt();
            int arr[] = new int[n];
            int distincts = 1;
            arr[0] = fs.nextInt();
            for (int i=1; i<n; i++) {
                arr[i] = fs.nextInt();
                if (arr[i] != arr[i-1]) distincts++;
            }
            int freq[] = new int[distincts];
            int j =0;
            freq[0] = 1;
            for(int i=1; i<n; i++) {
                if (arr[i] == arr[i-1]) freq[j]++;
                else {
                    j++;
                    freq[j] = 1;
                }
            }
            Arrays.sort(freq);
            long suffix[] = new long[distincts+1];

            for(int i=distincts-1; i>=0; i--) {
                suffix[i] = suffix[i+1] + freq[i];
            }
            int ans = 0;
            int idx = 0;
            long prev = 0;

            while(idx < distincts) {
                int curr = freq[idx];
                int left = distincts-idx;
                long sum = suffix[idx];

                long low = prev;
                long high = curr-1;

                if ((k-sum) % left == 0) {
                    long need = Math.ceilDiv(sum-k, left);
                    if (Math.max(low, need) <= high) ans++;
                }

                while(idx < distincts && freq[idx] == curr) {
                    idx++;
                }
                prev = curr;
            }
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}