package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int questionNumber = Integer.parseInt(br.readLine());
        int[] total = new int[11];

        total[1] = 1;
        total[2] = 2;
        total[3] = 4;

        for (int i = 4; i < total.length; i++) {
            total[i] = total[i - 1] + total[i - 2] + total[i - 3];
        }

        for (int i = 0; i < questionNumber; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(total[n]);
        }

    }
}
