package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int three = n * (m % 10);  // n * 5
        int four = n * ((m - (m % 10)) / 10 % 10);  // n * 8
        int five = n * (m / 100);  // n * 3
        int six = three + (four * 10) + (five * 100);

        System.out.println(three);
        System.out.println(four);
        System.out.println(five);
        System.out.println(six);
    }
}
