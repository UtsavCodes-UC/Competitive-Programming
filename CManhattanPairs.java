import java.io.*;
import java.util.*;

public class CManhattanPairs {

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

    static class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            ArrayList<Integer> q1 = new ArrayList<>();
            ArrayList<Integer> q2 = new ArrayList<>();
            ArrayList<Integer> q3 = new ArrayList<>();
            ArrayList<Integer> q4 = new ArrayList<>();
            
            

            Pair[] x = new Pair[n];
            Pair[] y = new Pair[n];

            for (int i = 0; i < n; i++) {
                int xi = fs.nextInt();
                int yi = fs.nextInt();

                x[i] = new Pair(xi, i);
                y[i] = new Pair(yi, i);
            }

            Arrays.sort(x, Comparator.comparingInt(a -> a.val));
            Arrays.sort(y, Comparator.comparingInt(a -> a.val));

            int[] rankX = new int[n];
            int[] rankY = new int[n];

            for (int i = 0; i < n; i++) {
                rankX[x[i].idx] = i;
                rankY[y[i].idx] = i;
            }

            for (int i = 0; i < n; i++) {

                boolean rightX = rankX[i] >= n/2;
                boolean upperY = rankY[i] >= n/2;

                if (!rightX && !upperY)
                    q1.add(i+1);
                else if (rightX && !upperY)
                    q2.add(i+1);
                else if (rightX && upperY)
                    q3.add(i+1);
                else
                    q4.add(i+1);
            }

            for (int i=0; i<q1.size(); i++) System.out.println(q1.get(i) + " " + q3.get(i));
            for (int i=0; i<q2.size(); i++) System.out.println(q2.get(i) + " " + q4.get(i));


            //sb.append("Answer").append('\n');
        }

        //System.out.print(sb);
    }
}