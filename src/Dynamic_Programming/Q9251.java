package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] strings = new char[3][1001];
        int[][] dp = new int[1001][1001];

        for (int i = 1; i <= 2; i++) {
            String line = br.readLine();
            strings[i] = line.toCharArray();
            // i = 1 : 행
            // i = 2 : 열
        }

        for (int i = 1; i <= strings[1].length; i++) {
            char ch = strings[1][i - 1];
            for (int j = 1; j <= strings[2].length; j++) {
                if (ch == strings[2][j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[strings[1].length][strings[2].length]);
    }
}
