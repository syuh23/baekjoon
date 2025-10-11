package Dynamic_Programming;

import java.util.*;

public class Q2_2 {
    public static void main(String[] args) throws Exception {

        String message = "my phone number is 01012345678 and may i have your phone number";
        int spoiler_ranges[][] = {
                {5, 5}, {25, 28}, {34, 40}, {53, 59}
        };

        // 1) 전체 단어 등장 횟수 저장
        Map<String, Integer> wordCount = new HashMap<>();
        Map<String, Integer> spoilCount = new HashMap<>();

        StringTokenizer st = new StringTokenizer(message, " ");
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 2) 스포일러 범위 단어 카운트
        for (int[] range : spoiler_ranges) {
            int start = range[0], end = range[1];
            while (start > 0 && message.charAt(start) != ' ') start--;
            while (end < message.length() - 1 && message.charAt(end) != ' ') end++;

            int segStart = start == 0 ? 0 : start + 1;
            int segEnd = end == message.length() - 1 ? end + 1 : end;

            if (segStart >= segEnd) continue;

            String spoilSegment = message.substring(segStart, segEnd);
            st = new StringTokenizer(spoilSegment, " ");
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                spoilCount.put(word, spoilCount.getOrDefault(word, 0) + 1);
            }
        }

        // 3) 중요 단어 판단 (직관적으로)
        Set<String> nonSpoilWords = new HashSet<>();
        Set<String> prevSpoilWords = new HashSet<>();
        int importantCount = 0;

        // 먼저 non-spoil 단어 기록
        for (String word : wordCount.keySet()) {
            if (!spoilCount.containsKey(word)) {
                nonSpoilWords.add(word);
            }
        }

        // 스포일러 단어를 순서대로 체크
        for (String word : spoilCount.keySet()) {
            // non-spoil 단어와 겹치면 중요 단어 아님
            if (nonSpoilWords.contains(word)) continue;

            // 이전에 중요 단어로 이미 선택된 단어면 제외
            if (prevSpoilWords.contains(word)) continue;

            // 조건 만족 → 중요 단어
            importantCount++;
            prevSpoilWords.add(word);
        }

        System.out.println(importantCount); // 중요 단어 개수 출력
    }
}

