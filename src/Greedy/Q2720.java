package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Q2720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int quarter, dime, nickel, penny;

        for (int t = 0; t < T; t ++) {
            int C = Integer.parseInt(br.readLine());

            quarter = C / 25;
            C -= quarter * 25;

            dime = C / 10;
            C -= dime * 10;

            nickel = C / 5;
            C -= nickel * 5;

            penny = C;

            bw.write(quarter + " " + dime + " " + nickel + " " + penny);
            bw.newLine();
        }

        bw.flush();
    }
}
