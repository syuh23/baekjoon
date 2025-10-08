package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] numbers = new int[N + 1][4];
        int[][] maxArr = new int[N + 1][4];
        int[][] minArr = new int[N + 1][4];
        int max = 0, min = 900000;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 1) {
                    maxArr[i][j] = numbers[i][j];
                    minArr[i][j] = numbers[i][j];
                }
                else {
                    if (j == 1) {
                        maxArr[i][j] = Math.max(maxArr[i - 1][j], maxArr[i - 1][j + 1]) + numbers[i][j];
                        minArr[i][j] = Math.min(minArr[i - 1][j], minArr[i - 1][j + 1]) + numbers[i][j];
                    }
                    else if (j == 3) {
                        maxArr[i][j] = Math.max(maxArr[i - 1][j - 1], maxArr[i - 1][j]) + numbers[i][j];
                        minArr[i][j] = Math.min(minArr[i - 1][j - 1], minArr[i - 1][j]) + numbers[i][j];
                    }
                    else {
                        maxArr[i][j] = Math.max(maxArr[i - 1][j - 1], Math.max(maxArr[i - 1][j], maxArr[i - 1][j + 1])) + numbers[i][j];
                        minArr[i][j] = Math.min(minArr[i - 1][j - 1], Math.min(minArr[i - 1][j], minArr[i - 1][j + 1])) + numbers[i][j];
                    }
                }

            }
        }

        for (int i = 1; i <= 3; i++) {
            max = Math.max(max, maxArr[N][i]);
            min = Math.min(min, minArr[N][i]);
        }

        System.out.println(max + " " + min);
    }
}
