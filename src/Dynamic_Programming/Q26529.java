package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q26529 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(br.readLine());
        int[] numbers = new int[repeat];
        int maximum = 0;

        for (int i = 0; i < repeat; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[i] = number;

            if (number > maximum)
                maximum = number;
        }

        int[] fibonacci = new int[maximum + 1];

        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i <= maximum; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        for (int i = 0; i < repeat; i ++) {
            System.out.println(fibonacci[numbers[i]]);
        }
    }
}
