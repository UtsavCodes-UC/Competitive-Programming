import java.io.*;
import java.util.*;

public class BPredominantFrequencyDivision {

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
            int arr[] = new int[n];

            for (int i=0; i<n; i++) {
                arr[i] = fs.nextInt();
            }
            int flags = 0;
            int curr1 = 0;
            int curr2 = 0;
            int curr3 = 0;
            int i = 0;
            for (i=0; i<n; i++) {
                if (arr[i] == 1) curr1++;
                else if(arr[i] == 2) curr2++;
                else if(arr[i] == 3) curr3++;
                if (curr1 >= curr2 + curr3) {
                    flags = 1;
                    break;
                }
            }
            i++;
            // System.out.println("i" + i);
            int count = curr1-curr2-curr3;
            for (; i<n && count > 0; i++) {
                if (arr[i] != 3) break;
                count--;
            }
            curr1 = 0;
            curr2 = 0;
            curr3 = 0;
            for (; i<n; i++) {
                if (arr[i] == 1) curr1++;
                else if(arr[i] == 2) curr2++;
                else if(arr[i] == 3) curr3++;
                if (curr1 + curr2 >= curr3) {
                    flags = 2;
                    break;
                }
            }
            i++;
            if (i < n) flags = 3;
            String ans = (flags == 3) ? "YES" : "NO";
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}