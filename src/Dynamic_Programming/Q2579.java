package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] score = new int[N + 1];
        int[] dp = new int[301];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());

            if (i == 1) {
                dp[i] = score[i];
            }
            else if (i == 2) {
                dp[i] = score[i] + dp[i - 1];
            }
            else {
                dp[i] = Math.max(dp[i - 2], (dp[i - 3] + score[i - 1])) + score[i];
            }
        }

        System.out.println(dp[N]);
    }
}
