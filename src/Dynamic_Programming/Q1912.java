package Dynamic_Programming;

import java.io.IOException;
import java.util.Scanner;

public class Q1912 {

    public static void main(String[] args) throws IOException {
        int n = new Scanner(System.in).nextInt();

        int k = (int) Math.sqrt(n);

        int dp[] = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i < k+1; i++) {
            dp[i*i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] > 0) continue;

            dp[i] = n;
            dp[i] = Math.min(dp[i], dp[i-1] + 1);

            int lm = (int)Math.sqrt(i);
            for (int j = 2 ; j < lm + 1; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + dp[j*j]);
            }
        }

        System.out.println(dp[n]);
    }
}
