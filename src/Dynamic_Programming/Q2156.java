package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = score[i];
            }
            else if (i == 2) {
                dp[i] = score[i - 1] + score[i];
            }
            else {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]));
            }
        }

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
