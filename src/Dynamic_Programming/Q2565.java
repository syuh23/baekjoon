package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] line = new int[501];
        int[] dp = new int[501];
        int maxNum = 0;
        int max = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            line[left] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, left);
        }

        dp[1] = 1;
        for (int i = 2; i <= maxNum; i++) {
            if (line[i] == 0)  continue;
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (line[j] == 0)  continue;
                if (line[i] > line[j])  dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        for (int i = 1; i <= maxNum; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}
