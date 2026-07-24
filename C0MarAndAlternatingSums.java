import java.io.*;
import java.util.*;

public class C0MarAndAlternatingSums {
    static final long MOD = 1000000007;
    static final int MAX = 200005;
    static long[] pow = new long[MAX];

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

    static void pre(){
        pow[0] = 1;
        for(int i = 1; i < MAX; i++){
            pow[i] = ((pow[i-1])%MOD*2)%MOD;
        }
    }
    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        pre();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            long arr[] = new long[n];

            for(int i=0; i<n; i++) arr[i] = fs.nextLong();

            HashMap<Long, Long> map = new HashMap<>();
            long cnt = 0;
            for(int i = 0; i < n; i++){
                map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
                if(arr[i] == -1){
                    cnt++;
                }
            }
            int d = map.size();
            long ans = pow[n-d];
 
            if (cnt != 0) {
                long p = 0;
 
                map.remove(-1L);
 
                for (long i : map.keySet()) {
 
                    if (map.containsKey(i + 1)) {
                        p = (p + ans) % MOD;
                    }
                }
 
                ans = (ans + p) % MOD;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}