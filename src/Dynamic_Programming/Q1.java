package Dynamic_Programming;


public class Q1 {

    public static int firstAllYellow(int[][] signals) {
        int n = signals.length;
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }

        int limit = times[0];
        for (int i = 1; i < n; i++) {
            limit = lcm(limit, times[i]);
        }

        for (int now = 1; now <= limit; now++) {
            boolean allY = true;

            for (int i = 0; i < n; i++) {
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];
                int phase = (now - 1) % (g + y + r);

                if (!(phase >= g && phase < g + y)) {
                    allY = false;
                    break;
                }
            }

            if (allY) {
                return now;
            }
        }

        return -1;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        int[][] signals = {
                {1, 1, 4}, {2, 1, 3}, {3, 1, 2}, {4, 1, 1}
        };
        System.out.println(firstAllYellow(signals));
    }
}
