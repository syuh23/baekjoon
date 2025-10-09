package Dynamic_Programming;

import java.io.*;

public class Q9252 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] strings = new char[1001][1001];
        for (int i = 1; i <= 2; i++) {
            String line = br.readLine();
            strings[i] = line.toCharArray();
        }

        int row = strings[1].length;
        int col = strings[2].length;
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (strings[1][i - 1] == strings[2][j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        bw.write(dp[row][col] + "\n");

        char[] result = new char[dp[row][col] + 1];
        int index = 1;

        while (row != 0 && col != 0) {
            if (dp[row][col] != dp[row - 1][col] && dp[row][col] != dp[row][col - 1]) {
                result[index] = strings[1][row - 1];
                index ++;
                row --;
                col --;
            }
            else if (dp[row][col] == dp[row - 1][col]) {
                row --;
            }
            else if (dp[row][col] == dp[row][col - 1]) {
                col --;
            }
        }

        for (int i = result.length - 1; i >= 1; i--) {
            bw.write(result[i] + "");
        }

        bw.flush();
        bw.close();
    }
}
