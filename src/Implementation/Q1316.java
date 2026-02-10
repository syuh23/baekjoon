package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1316 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i ++) {

            String word = br.readLine();
            ArrayList<Character> charList = new ArrayList<>();
            char prev = '0';
            boolean result = true;

            for (char c : word.toCharArray()) {
                if (prev == c)
                    continue;

                if (charList.contains(c)) {
                    result = false;
                    break;
                }
                else {
                    charList.add(c);
                    prev = c;
                }
            }

            if (result)
                answer ++;

        }

        System.out.println(answer);
    }
}
