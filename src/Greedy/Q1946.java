package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i ++) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];
            int result = 0;

            for (int j = 0; j < N; j ++) {
                st = new StringTokenizer(br.readLine());
                score[j][0] = Integer.parseInt(st.nextToken());
                score[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(score, Comparator.comparingInt(a -> a[0]));

            for (int document = 0; document < N; document++) {
                boolean check = true;

                for (int interview = 0; interview < document; interview ++) {
                    if (score[document][1] > score[interview][1]) {
                        check = false;
                        break;
                    }
                }

                if (check)
                    result ++;
            }

            System.out.println(result);
        }
    }
}
