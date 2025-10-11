package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] dp = new boolean [K + 1];
        dp[1] = true;

        for (int i = 2; i <= K / 2; i++) {
            for (int j = 2; i * j <= K; j ++) {
                if (dp[i * j]) continue;
                dp[i * j] = true;
            }
        }

        for (int i = N; i <= K; i++) {
            if (!dp[i]) System.out.println(i);
        }
    }
}
