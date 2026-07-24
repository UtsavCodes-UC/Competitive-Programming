import java.io.*;
import java.util.*;

public class BTrianglesOnARectangle {

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

            int w = fs.nextInt();
            int h = fs.nextInt();

            int k = fs.nextInt();

            int arr[] = new int[k];

            for (int i=0; i<k; i++) {
                arr[i] = fs.nextInt();
            }

            int a = arr[k-1]-arr[0];

            k = fs.nextInt();
            arr = new int[k];

            for(int i=0; i<k; i++) {
                arr[i] = fs.nextInt();
            }

            int b = arr[k-1]-arr[0];

            long maxArea = (long) Math.max(a,b) * (long) h;

            k = fs.nextInt();
            arr = new int[k];

            for(int i=0; i<k; i++) {
                arr[i] = fs.nextInt();
            }
            a = arr[k-1] - arr[0];

            k=fs.nextInt();
            arr = new int[k];

            for(int i=0; i<k; i++) {
                arr[i] = fs.nextInt();
            }
            b = arr[k-1] - arr[0];

            maxArea = Math.max(maxArea, (long) Math.max(a,b)* (long) w);

            sb.append(maxArea).append('\n');
        }

        System.out.print(sb);
    }
}