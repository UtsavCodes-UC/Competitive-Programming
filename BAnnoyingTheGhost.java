import java.io.*;
import java.util.*;

public class BAnnoyingTheGhost {

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
    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];

            for (int i=0; i<n; i++) {
                a[i] =fs.nextLong();
            }

            for (int i=0; i<n; i++) {
                b[i] =fs.nextLong();
            }
            long swaps = 0;

            for (int i=0; i<n; i++) {
                int idx = -1;
                for (int j=i; j<n; j++) {
                    if (a[j] <= b[i]) {
                        idx = j;
                        break;
                    }
                }

                if (idx == -1) {
                    swaps = -1;
                    break;
                }

                for (int j=idx; j>i; j--) {
                    long temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                    swaps++;
                }
            }
            
            sb.append(swaps).append('\n');
        }

        System.out.print(sb);
    }
}