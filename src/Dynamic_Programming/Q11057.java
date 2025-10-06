package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 1) {
                    dp[i][j] = j + 1;
                }
                else if (i == 2) {
                    if (j == 0) {
                        dp[i][j] = 10;
                    }
                    else {
                        dp[i][j] = (dp[i][j - 1] + 10 - j) % 10007;
                    }
                }
                else {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][9] % 10007;
                    }
                    else {
                        dp[i][j] = (dp[i - 1][9] - dp[i - 1][j - 1] + dp[i][j - 1]) % 10007;
                    }
                }
            }
        }

        System.out.println(dp[n][9]);
    }
}
