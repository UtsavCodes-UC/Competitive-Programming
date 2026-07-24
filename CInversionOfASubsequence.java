import java.io.*;
import java.util.*;

public class CInversionOfASubsequence {

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

            int n = fs.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            boolean isOne = false;
            for(int i=0; i<n; i++) {
                a[i] = fs.nextInt();
                if (a[i] == 1) isOne = true;
            }

            boolean isZero = false;
            for(int i=0; i<n; i++) {
                b[i] = fs.nextInt();
                if (b[i] == 0) isZero = true;
            }

            boolean equal = true;
            int changes= 0;
            for (int i=0; i<n; i++) {
                if (a[i] != b[i]) equal = false;
                if (a[i] == 1 && b[i] == 0) changes++;
            }

            int ans;
            if (equal) ans = 0;
            else if (!isOne || !isZero) ans = -1;
            else if(changes%2 == 0) ans = 2;
            else ans = 1;

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}