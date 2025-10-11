package Dynamic_Programming;

import java.util.*;

public class Q2 {
    public static void main(String[] args) throws Exception {

        String message = "my phone number is 01012345678 and may i have your phone number";
        int spoiler_ranges[][] = {
                {62, 62}
        };

        Map<String, Integer> wordCount = new HashMap<>(), spoilCount = new HashMap<>();

        StringTokenizer st = new StringTokenizer(message, " ");
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int[] range : spoiler_ranges) {
            int start = range[0], end = range[1];
            while (start > 0 && message.charAt(start) != ' ') start--;
            while (end < message.length() - 1 && message.charAt(end) != ' ') end++;

            int segStart = start == 0 ? 0 : start + 1;
            int segEnd = end == message.length() - 1 ? end + 1 : end;

            if (segStart >= segEnd) continue;

            String spoilWord = message.substring(segStart, segEnd);

            st = new StringTokenizer(spoilWord, " ");
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                spoilCount.put(word, spoilCount.getOrDefault(word, 0) + 1);
            }

        }

        int answer = 0;

        for (String word : spoilCount.keySet()) {
            if (wordCount.get(word) == spoilCount.get(word)) answer++;
        }

        System.out.println(answer);
    }
}
