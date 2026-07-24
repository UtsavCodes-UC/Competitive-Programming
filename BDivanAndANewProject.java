import java.io.*;
import java.util.*;

public class BDivanAndANewProject {

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
            int arr[][] = new int[n][2];

            for(int i=0; i<n; i++) {
                arr[i][0] = fs.nextInt();
                arr[i][1] = i;
            }
            
            Arrays.sort(arr, (a,b) -> Integer.compare(b[0], a[0]));

            int pos = 1;
            long count = 0;
            for (int i=0; i<n; i+=2) {
                count += 2L * (long) pos * (long) arr[i][0];
                arr[i][0] = pos;
                if (i+1 < n) {
                    count += 2L * (long) pos * (long) arr[i+1][0];
                    arr[i+1][0] = -pos;
                }
                pos++;
            }

            Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
            
            System.out.println(count);
            System.out.print(0 + " ");
            for (int i=0; i<n; i++) {
                System.out.print(arr[i][0] + " ");
            }
            System.out.println();
        }
    }
}