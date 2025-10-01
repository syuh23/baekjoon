package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            int div3 = 1000001, div2 = 1000001;

            if (i % 3 == 0) {
                div3 = dp[i / 3];
            }
            if (i % 2 == 0) {
                div2 = dp[i / 2];
            }

            dp[i] = Math.min(dp[i - 1], (Math.min(div3, div2))) + 1;

        }

        System.out.println(dp[N]);
    }
}
