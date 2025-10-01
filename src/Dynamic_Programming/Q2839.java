package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[5001];

        dp[1] = dp[2] = dp[4] = -1;
        dp[3] = dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            int minus3 = dp[i - 3];
            int minus5 = dp[i - 5];

            if (minus3 == -1 && minus5 == -1) {
                dp[i] = -1;
            }
            else if (minus3 == -1 || minus5 == -1) {
                int prev = Math.max(minus3, minus5);
                dp[i] = prev + 1;
            }
            else {
                int prev = Math.min(dp[i - 3], dp[i - 5]);
                dp[i] = prev + 1;
            }
        }

        System.out.println(dp[N]);
    }
}
