package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int [N + 1];
        int[] dp = new int [K + 1];

        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            coins [i] = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= K; j++) {
                if (coins[i] <= j) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        System.out.println(dp[K]);
    }
}
