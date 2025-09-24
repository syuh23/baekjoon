package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int repeat = 0; repeat < T; repeat++) {
            String line = br.readLine();
            int N = Integer.parseInt(line.split(" ")[0]);
            int M = Integer.parseInt(line.split(" ")[1]);
            int sum = 0;

            int[][] result = new int[N + 1][M - N + 1];
            ArrayList<Integer> lastValue = new ArrayList<>(2);
            lastValue.add(1, M - N + 1);
            result.addLast(lastValue);

            ArrayList<Integer> secondLastValue = new ArrayList<>(M - N + 1);
            secondLastValue.add(0);
            for (int i = 1; i <= M - N; i++) {
                secondLastValue.add(secondLastValue.get(i - 1) + i);
            }
            result.add(N - 1, secondLastValue);

            for (int i = N - 2; i > 0; i--) {
                ArrayList<Integer> newValue = new ArrayList<>(M - N + 1);
                newValue.add(1, 1);
                for (int j = 2; j <= M - N; j++) {
                    newValue.add(j, newValue.get(j - 1) + result.get(i - 1).get(j));
                }
            }

            for (int i = 1; i <= N; i++) {
                int size = result.get(i).size();

                for (int j = 1; j <= size; j++) {
                    sum += result.get(i).get(j);
                }
            }

            System.out.println(sum);
        }
    }
}
