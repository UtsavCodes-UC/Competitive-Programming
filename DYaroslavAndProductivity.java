import java.io.*;
import java.util.*;

public class DYaroslavAndProductivity {

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

    static final long NEG = -(1L << 60);
    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();


        while (t-- > 0) {

            int n = fs.nextInt();
            int m = fs.nextInt();

            long a[] = new long[n+1];

            for(int i=1; i<=n; i++) {
                a[i] = fs.nextLong();
            }

            int b[] = new int[m];
            boolean available[] = new boolean[n+1];
            Arrays.fill(available, false);
            for(int i=0; i<m; i++) {
                b[i] = fs.nextInt();
                available[b[i]] = true;
            }

            long cases[] = new long[] {0, NEG};

            for(int i=n; i>0; i--) {
                long negCase[] = new long[] {NEG, NEG};

                for(int j=0; j<2; j++) {
                    if (cases[j] == NEG) continue;
                    if (!available[i]) {
                        int curr = j;
                        long val = cases[j] + (curr == 0 ? a[i] : -a[i]);
                        negCase[curr] = Math.max(negCase[curr], val);
                    }
                    else {
                        for(int take=0; take<2; take++) {
                            int curr = j^take;
                            long val = cases[j] + (curr == 0 ? a[i] : -a[i]);
                            negCase[curr] = Math.max(negCase[curr], val);
                        }
                    }
                }

                cases = negCase;
            }
            long ans = Math.max(cases[0], cases[1]);
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}