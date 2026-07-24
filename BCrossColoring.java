import java.io.*;
import java.util.*;

public class BCrossColoring {

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
            int m = fs.nextInt();
            long k = fs.nextInt();
            int q = fs.nextInt();

            int x[] = new int[q];
            int y[] = new int[q];

            for (int i=0; i<q; i++) {
                x[i] = fs.nextInt();
                y[i] = fs.nextInt();
            }

            boolean row[] = new boolean[n+1];
            boolean col[] = new boolean[m+1];

            int rows = 0;
            int cols = 0;
            long ans = 1;

            for (int i=q-1; i>=0; i--) {
                boolean take = false;

                if ((!row[x[i]] && cols<m) || (!col[y[i]] && rows<n )) take = true;
                if (take) ans = (ans*k) % 998244353L;
                if (!row[x[i]]) {
                    row[x[i]] = true;
                    rows++;
                }

                if(!col[y[i]]) {
                    col[y[i]] = true;
                    cols++;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}